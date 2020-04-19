package com.electronic.contants;

public class WorkOrderConstants {
    //审批中
    public static  final Integer APPROVAL = 10;

    //审批拒绝
    public static  final Integer APPROVE_FIALE = 70;

    //审批结束
    public static  final Integer APPROVE_SUCCESS = 90;


    public static String getStatus(Integer status){
        if (status == APPROVAL){
            return "审批中";
        }else if (status == APPROVE_FIALE){
            return "审批拒绝";
        }else {
            return "审批通过";
        }
    }
}
