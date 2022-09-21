package com.thekim12.practicexp.xplatformpracticeuser;


import com.tobesoft.xplatform.data.DataSet;
import com.tobesoft.xplatform.data.DataTypes;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String emplId;

    @Column(nullable = false)
    private String fullname;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String hireDate;

    @Column(nullable = false)
    private String married;

    @Column(nullable = false)
    private String deptId;

    @Column(nullable = false)
    private BigDecimal salary;

    @Column(nullable = false)
    private String memo;

    public User toEntity(){
        return User.builder()
                .fullname(fullname)
                .hireDate(hireDate)
                .deptId(deptId)
                .emplId(emplId)
                .gender(gender)
                .married(married)
                .salary(salary)
                .memo(memo)
                .build();
    }

    // 유저 데이터셋의 이름과 칼럼설정

    public DataSet setRowOfUserDataSet(DataSet dataSet){
        int row = dataSet.newRow();
        dataSet.set(row, "EMPL_ID", this.getEmplId());
        dataSet.set(row, "FULL_NAME", this.getFullname());
        dataSet.set(row, "HIRE_DATE", this.getHireDate());
        dataSet.set(row, "MARRIED", this.getMarried());
        dataSet.set(row, "SALARY", this.getSalary());
        dataSet.set(row, "GENDER", this.getGender());
        dataSet.set(row, "DEPT_ID", this.getDeptId());
        dataSet.set(row, "EMPL_MEMO", this.getMemo());
        return dataSet;
    }

}
