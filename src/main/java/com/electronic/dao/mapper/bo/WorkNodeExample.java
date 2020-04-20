package com.electronic.dao.mapper.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkNodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkNodeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andNodeIdIsNull() {
            addCriterion("node_id is null");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNotNull() {
            addCriterion("node_id is not null");
            return (Criteria) this;
        }

        public Criteria andNodeIdEqualTo(Integer value) {
            addCriterion("node_id =", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotEqualTo(Integer value) {
            addCriterion("node_id <>", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThan(Integer value) {
            addCriterion("node_id >", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_id >=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThan(Integer value) {
            addCriterion("node_id <", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("node_id <=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdIn(List<Integer> values) {
            addCriterion("node_id in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotIn(List<Integer> values) {
            addCriterion("node_id not in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdBetween(Integer value1, Integer value2) {
            addCriterion("node_id between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("node_id not between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdIsNull() {
            addCriterion("work_order_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdIsNotNull() {
            addCriterion("work_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdEqualTo(Integer value) {
            addCriterion("work_order_id =", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdNotEqualTo(Integer value) {
            addCriterion("work_order_id <>", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdGreaterThan(Integer value) {
            addCriterion("work_order_id >", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("work_order_id >=", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdLessThan(Integer value) {
            addCriterion("work_order_id <", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("work_order_id <=", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdIn(List<Integer> values) {
            addCriterion("work_order_id in", values, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdNotIn(List<Integer> values) {
            addCriterion("work_order_id not in", values, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("work_order_id between", value1, value2, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("work_order_id not between", value1, value2, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andNodeOrderIsNull() {
            addCriterion("node_order is null");
            return (Criteria) this;
        }

        public Criteria andNodeOrderIsNotNull() {
            addCriterion("node_order is not null");
            return (Criteria) this;
        }

        public Criteria andNodeOrderEqualTo(Integer value) {
            addCriterion("node_order =", value, "nodeOrder");
            return (Criteria) this;
        }

        public Criteria andNodeOrderNotEqualTo(Integer value) {
            addCriterion("node_order <>", value, "nodeOrder");
            return (Criteria) this;
        }

        public Criteria andNodeOrderGreaterThan(Integer value) {
            addCriterion("node_order >", value, "nodeOrder");
            return (Criteria) this;
        }

        public Criteria andNodeOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_order >=", value, "nodeOrder");
            return (Criteria) this;
        }

        public Criteria andNodeOrderLessThan(Integer value) {
            addCriterion("node_order <", value, "nodeOrder");
            return (Criteria) this;
        }

        public Criteria andNodeOrderLessThanOrEqualTo(Integer value) {
            addCriterion("node_order <=", value, "nodeOrder");
            return (Criteria) this;
        }

        public Criteria andNodeOrderIn(List<Integer> values) {
            addCriterion("node_order in", values, "nodeOrder");
            return (Criteria) this;
        }

        public Criteria andNodeOrderNotIn(List<Integer> values) {
            addCriterion("node_order not in", values, "nodeOrder");
            return (Criteria) this;
        }

        public Criteria andNodeOrderBetween(Integer value1, Integer value2) {
            addCriterion("node_order between", value1, value2, "nodeOrder");
            return (Criteria) this;
        }

        public Criteria andNodeOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("node_order not between", value1, value2, "nodeOrder");
            return (Criteria) this;
        }

        public Criteria andNodeOperateStatusIsNull() {
            addCriterion("node_operate_status is null");
            return (Criteria) this;
        }

        public Criteria andNodeOperateStatusIsNotNull() {
            addCriterion("node_operate_status is not null");
            return (Criteria) this;
        }

        public Criteria andNodeOperateStatusEqualTo(Integer value) {
            addCriterion("node_operate_status =", value, "nodeOperateStatus");
            return (Criteria) this;
        }

        public Criteria andNodeOperateStatusNotEqualTo(Integer value) {
            addCriterion("node_operate_status <>", value, "nodeOperateStatus");
            return (Criteria) this;
        }

        public Criteria andNodeOperateStatusGreaterThan(Integer value) {
            addCriterion("node_operate_status >", value, "nodeOperateStatus");
            return (Criteria) this;
        }

        public Criteria andNodeOperateStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_operate_status >=", value, "nodeOperateStatus");
            return (Criteria) this;
        }

        public Criteria andNodeOperateStatusLessThan(Integer value) {
            addCriterion("node_operate_status <", value, "nodeOperateStatus");
            return (Criteria) this;
        }

        public Criteria andNodeOperateStatusLessThanOrEqualTo(Integer value) {
            addCriterion("node_operate_status <=", value, "nodeOperateStatus");
            return (Criteria) this;
        }

        public Criteria andNodeOperateStatusIn(List<Integer> values) {
            addCriterion("node_operate_status in", values, "nodeOperateStatus");
            return (Criteria) this;
        }

        public Criteria andNodeOperateStatusNotIn(List<Integer> values) {
            addCriterion("node_operate_status not in", values, "nodeOperateStatus");
            return (Criteria) this;
        }

        public Criteria andNodeOperateStatusBetween(Integer value1, Integer value2) {
            addCriterion("node_operate_status between", value1, value2, "nodeOperateStatus");
            return (Criteria) this;
        }

        public Criteria andNodeOperateStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("node_operate_status not between", value1, value2, "nodeOperateStatus");
            return (Criteria) this;
        }

        public Criteria andNodeOperateTimeIsNull() {
            addCriterion("node_operate_time is null");
            return (Criteria) this;
        }

        public Criteria andNodeOperateTimeIsNotNull() {
            addCriterion("node_operate_time is not null");
            return (Criteria) this;
        }

        public Criteria andNodeOperateTimeEqualTo(Date value) {
            addCriterion("node_operate_time =", value, "nodeOperateTime");
            return (Criteria) this;
        }

        public Criteria andNodeOperateTimeNotEqualTo(Date value) {
            addCriterion("node_operate_time <>", value, "nodeOperateTime");
            return (Criteria) this;
        }

        public Criteria andNodeOperateTimeGreaterThan(Date value) {
            addCriterion("node_operate_time >", value, "nodeOperateTime");
            return (Criteria) this;
        }

        public Criteria andNodeOperateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("node_operate_time >=", value, "nodeOperateTime");
            return (Criteria) this;
        }

        public Criteria andNodeOperateTimeLessThan(Date value) {
            addCriterion("node_operate_time <", value, "nodeOperateTime");
            return (Criteria) this;
        }

        public Criteria andNodeOperateTimeLessThanOrEqualTo(Date value) {
            addCriterion("node_operate_time <=", value, "nodeOperateTime");
            return (Criteria) this;
        }

        public Criteria andNodeOperateTimeIn(List<Date> values) {
            addCriterion("node_operate_time in", values, "nodeOperateTime");
            return (Criteria) this;
        }

        public Criteria andNodeOperateTimeNotIn(List<Date> values) {
            addCriterion("node_operate_time not in", values, "nodeOperateTime");
            return (Criteria) this;
        }

        public Criteria andNodeOperateTimeBetween(Date value1, Date value2) {
            addCriterion("node_operate_time between", value1, value2, "nodeOperateTime");
            return (Criteria) this;
        }

        public Criteria andNodeOperateTimeNotBetween(Date value1, Date value2) {
            addCriterion("node_operate_time not between", value1, value2, "nodeOperateTime");
            return (Criteria) this;
        }

        public Criteria andNodeOperateResultIsNull() {
            addCriterion("node_operate_result is null");
            return (Criteria) this;
        }

        public Criteria andNodeOperateResultIsNotNull() {
            addCriterion("node_operate_result is not null");
            return (Criteria) this;
        }

        public Criteria andNodeOperateResultEqualTo(Integer value) {
            addCriterion("node_operate_result =", value, "nodeOperateResult");
            return (Criteria) this;
        }

        public Criteria andNodeOperateResultNotEqualTo(Integer value) {
            addCriterion("node_operate_result <>", value, "nodeOperateResult");
            return (Criteria) this;
        }

        public Criteria andNodeOperateResultGreaterThan(Integer value) {
            addCriterion("node_operate_result >", value, "nodeOperateResult");
            return (Criteria) this;
        }

        public Criteria andNodeOperateResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_operate_result >=", value, "nodeOperateResult");
            return (Criteria) this;
        }

        public Criteria andNodeOperateResultLessThan(Integer value) {
            addCriterion("node_operate_result <", value, "nodeOperateResult");
            return (Criteria) this;
        }

        public Criteria andNodeOperateResultLessThanOrEqualTo(Integer value) {
            addCriterion("node_operate_result <=", value, "nodeOperateResult");
            return (Criteria) this;
        }

        public Criteria andNodeOperateResultIn(List<Integer> values) {
            addCriterion("node_operate_result in", values, "nodeOperateResult");
            return (Criteria) this;
        }

        public Criteria andNodeOperateResultNotIn(List<Integer> values) {
            addCriterion("node_operate_result not in", values, "nodeOperateResult");
            return (Criteria) this;
        }

        public Criteria andNodeOperateResultBetween(Integer value1, Integer value2) {
            addCriterion("node_operate_result between", value1, value2, "nodeOperateResult");
            return (Criteria) this;
        }

        public Criteria andNodeOperateResultNotBetween(Integer value1, Integer value2) {
            addCriterion("node_operate_result not between", value1, value2, "nodeOperateResult");
            return (Criteria) this;
        }

        public Criteria andNodeOperateDescIsNull() {
            addCriterion("node_operate_desc is null");
            return (Criteria) this;
        }

        public Criteria andNodeOperateDescIsNotNull() {
            addCriterion("node_operate_desc is not null");
            return (Criteria) this;
        }

        public Criteria andNodeOperateDescEqualTo(String value) {
            addCriterion("node_operate_desc =", value, "nodeOperateDesc");
            return (Criteria) this;
        }

        public Criteria andNodeOperateDescNotEqualTo(String value) {
            addCriterion("node_operate_desc <>", value, "nodeOperateDesc");
            return (Criteria) this;
        }

        public Criteria andNodeOperateDescGreaterThan(String value) {
            addCriterion("node_operate_desc >", value, "nodeOperateDesc");
            return (Criteria) this;
        }

        public Criteria andNodeOperateDescGreaterThanOrEqualTo(String value) {
            addCriterion("node_operate_desc >=", value, "nodeOperateDesc");
            return (Criteria) this;
        }

        public Criteria andNodeOperateDescLessThan(String value) {
            addCriterion("node_operate_desc <", value, "nodeOperateDesc");
            return (Criteria) this;
        }

        public Criteria andNodeOperateDescLessThanOrEqualTo(String value) {
            addCriterion("node_operate_desc <=", value, "nodeOperateDesc");
            return (Criteria) this;
        }

        public Criteria andNodeOperateDescLike(String value) {
            addCriterion("node_operate_desc like", value, "nodeOperateDesc");
            return (Criteria) this;
        }

        public Criteria andNodeOperateDescNotLike(String value) {
            addCriterion("node_operate_desc not like", value, "nodeOperateDesc");
            return (Criteria) this;
        }

        public Criteria andNodeOperateDescIn(List<String> values) {
            addCriterion("node_operate_desc in", values, "nodeOperateDesc");
            return (Criteria) this;
        }

        public Criteria andNodeOperateDescNotIn(List<String> values) {
            addCriterion("node_operate_desc not in", values, "nodeOperateDesc");
            return (Criteria) this;
        }

        public Criteria andNodeOperateDescBetween(String value1, String value2) {
            addCriterion("node_operate_desc between", value1, value2, "nodeOperateDesc");
            return (Criteria) this;
        }

        public Criteria andNodeOperateDescNotBetween(String value1, String value2) {
            addCriterion("node_operate_desc not between", value1, value2, "nodeOperateDesc");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}