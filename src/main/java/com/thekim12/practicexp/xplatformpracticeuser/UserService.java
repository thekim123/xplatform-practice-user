package com.thekim12.practicexp.xplatformpracticeuser;

import com.thekim12.practicexp.xplatformpracticeuser.dto.UserJoinDto;
import com.thekim12.practicexp.xplatformpracticeuser.model.User;
import com.tobesoft.xplatform.data.*;
import com.tobesoft.xplatform.tx.HttpPlatformRequest;
import com.tobesoft.xplatform.tx.HttpPlatformResponse;
import com.tobesoft.xplatform.tx.PlatformException;
import com.tobesoft.xplatform.tx.PlatformType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	@Transactional()
	public void findAllUser(HttpServletResponse response) throws PlatformException {
		List<User> userList = userRepository.findAll();
		System.out.println(userList.get(1).getFullname());

		PlatformData platformData = new PlatformData();

		DataSet dataSet = null;
		int nErrorCode = 0;
		String strErrorMsg = "START";

		dataSet = createUserDataSet(new DataSet());

		for (int i = 0; i < userList.size(); i++) {
			User tempUser = userList.get(i);
			tempUser.setRowOfUserDataSet(dataSet);

			nErrorCode = 0;
			strErrorMsg = "SUCCESS";
		}
		platformData.addDataSet(dataSet);

		VariableList varList = platformData.getVariableList();
		varList.add("ErrorCode", nErrorCode);
		varList.add("ErrorMsg", strErrorMsg);

		HttpPlatformResponse pRes = new HttpPlatformResponse(response, PlatformType.CONTENT_TYPE_XML, "UTF-8");
		pRes.setData(platformData);
		pRes.sendData();

	}

	@Transactional
	public void joinUser(HttpServletRequest request) throws PlatformException {
		PlatformData platformData = new PlatformData();
		HttpPlatformRequest pReq = new HttpPlatformRequest(request);
		pReq.receiveData();
		PlatformData i_xpData = pReq.getData();

		VariableList in_vl = i_xpData.getVariableList();
		String in_var2 = in_vl.getString("sVal1");
		DataSet dataSet = i_xpData.getDataSet("in_ds");

		for (int i = 0; i < dataSet.getRowCount(); i++) {
			int rowType = dataSet.getRowType(i);
			if(rowType == DataSet.ROW_TYPE_INSERTED) {
				User user = new User();
				user.builder();
				
				userRepository.save(user);
			}
		}

	}
	
	@Transactional
	public void deleteUser(HttpServletRequest request) throws PlatformException {
		PlatformData platformData = new PlatformData();
		HttpPlatformRequest pReq = new HttpPlatformRequest(request);
		pReq.receiveData();
		PlatformData i_xpData = pReq.getData();
		
		VariableList in_vl = i_xpData.getVariableList();
		String in_var2 = in_vl.getString("sVal1");
		DataSet dataSet = i_xpData.getDataSet("in_ds");
		
		for (int i = 0; i < dataSet.getRemovedRowCount(); i++) {
			String emplId = dataSet.getRemovedData(i, "EMPL_ID").toString();
			userRepository.deleteByEmplId(emplId);
		}	
	}

	@Transactional
	public void updateUser(User user) {
	
	}

	public DataSet createUserDataSet(DataSet dataSet) {
		dataSet.setName("ds_employees");
		dataSet.addColumn("EMPL_ID", DataTypes.STRING, (short) 10);
		dataSet.addColumn("FULL_NAME", DataTypes.STRING, (short) 50);
		dataSet.addColumn("HIRE_DATE", DataTypes.STRING, (short) 30);
		dataSet.addColumn("MARRIED", DataTypes.STRING, (short) 1);
		dataSet.addColumn("SALARY", DataTypes.STRING, (short) 10);
		dataSet.addColumn("GENDER", DataTypes.STRING, (short) 1);
		dataSet.addColumn("DEPT_ID", DataTypes.STRING, (short) 10);
		dataSet.addColumn("EMPL_MEMO", DataTypes.STRING, (short) 300);
		return dataSet;
	}

}
