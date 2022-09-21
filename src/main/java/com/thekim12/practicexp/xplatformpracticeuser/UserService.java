package com.thekim12.practicexp.xplatformpracticeuser;

import com.tobesoft.xplatform.data.*;
import com.tobesoft.xplatform.tx.HttpPlatformResponse;
import com.tobesoft.xplatform.tx.PlatformException;
import com.tobesoft.xplatform.tx.PlatformType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional()
    public void findAllUser(HttpServletResponse response ) throws PlatformException {
        List<User> userList = userRepository.findAll();
        System.out.println(userList.get(1).getFullname());

        PlatformData platformData = new PlatformData();

        DataSet dataSet = null;
        int nErrorCode = 0;
        String strErrorMsg = "START";

        dataSet = createUserDataSet(new DataSet());

        for (int i = 0; i < userList.size() ; i++) {
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
    public void joinUser(User user){
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(User user){
    }

    public DataSet createUserDataSet(DataSet dataSet){
        dataSet.setName("ds_employees");
        dataSet.addColumn("EMPL_ID", DataTypes.STRING, (short)10);
        dataSet.addColumn("FULL_NAME", DataTypes.STRING, (short)50);
        dataSet.addColumn("HIRE_DATE", DataTypes.STRING, (short)30);
        dataSet.addColumn("MARRIED", DataTypes.STRING, (short)1);
        dataSet.addColumn("SALARY", DataTypes.STRING, (short)10);
        dataSet.addColumn("GENDER", DataTypes.STRING, (short)1);
        dataSet.addColumn("DEPT_ID", DataTypes.STRING, (short)10);
        dataSet.addColumn("EMPL_MEMO", DataTypes.STRING, (short) 300);
        return dataSet;
    }

}
