package com.electronic.dao.mapper.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkOrderExample() {
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

        public Criteria andWorkOrderCodeIsNull() {
            addCriterion("work_order_code is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeIsNotNull() {
            addCriterion("work_order_code is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeEqualTo(String value) {
            addCriterion("work_order_code =", value, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeNotEqualTo(String value) {
            addCriterion("work_order_code <>", value, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeGreaterThan(String value) {
            addCriterion("work_order_code >", value, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("work_order_code >=", value, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeLessThan(String value) {
            addCriterion("work_order_code <", value, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeLessThanOrEqualTo(String value) {
            addCriterion("work_order_code <=", value, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeLike(String value) {
            addCriterion("work_order_code like", value, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeNotLike(String value) {
            addCriterion("work_order_code not like", value, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeIn(List<String> values) {
            addCriterion("work_order_code in", values, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeNotIn(List<String> values) {
            addCriterion("work_order_code not in", values, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeBetween(String value1, String value2) {
            addCriterion("work_order_code between", value1, value2, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeNotBetween(String value1, String value2) {
            addCriterion("work_order_code not between", value1, value2, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameIsNull() {
            addCriterion("work_order_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameIsNotNull() {
            addCriterion("work_order_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameEqualTo(String value) {
            addCriterion("work_order_name =", value, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameNotEqualTo(String value) {
            addCriterion("work_order_name <>", value, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameGreaterThan(String value) {
            addCriterion("work_order_name >", value, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameGreaterThanOrEqualTo(String value) {
            addCriterion("work_order_name >=", value, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameLessThan(String value) {
            addCriterion("work_order_name <", value, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameLessThanOrEqualTo(String value) {
            addCriterion("work_order_name <=", value, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameLike(String value) {
            addCriterion("work_order_name like", value, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameNotLike(String value) {
            addCriterion("work_order_name not like", value, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameIn(List<String> values) {
            addCriterion("work_order_name in", values, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameNotIn(List<String> values) {
            addCriterion("work_order_name not in", values, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameBetween(String value1, String value2) {
            addCriterion("work_order_name between", value1, value2, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameNotBetween(String value1, String value2) {
            addCriterion("work_order_name not between", value1, value2, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNull() {
            addCriterion("work_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNotNull() {
            addCriterion("work_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeEqualTo(String value) {
            addCriterion("work_type =", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotEqualTo(String value) {
            addCriterion("work_type <>", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThan(String value) {
            addCriterion("work_type >", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThanOrEqualTo(String value) {
            addCriterion("work_type >=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThan(String value) {
            addCriterion("work_type <", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThanOrEqualTo(String value) {
            addCriterion("work_type <=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLike(String value) {
            addCriterion("work_type like", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotLike(String value) {
            addCriterion("work_type not like", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIn(List<String> values) {
            addCriterion("work_type in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotIn(List<String> values) {
            addCriterion("work_type not in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeBetween(String value1, String value2) {
            addCriterion("work_type between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotBetween(String value1, String value2) {
            addCriterion("work_type not between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andOrganizerIsNull() {
            addCriterion("organizer is null");
            return (Criteria) this;
        }

        public Criteria andOrganizerIsNotNull() {
            addCriterion("organizer is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizerEqualTo(String value) {
            addCriterion("organizer =", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotEqualTo(String value) {
            addCriterion("organizer <>", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerGreaterThan(String value) {
            addCriterion("organizer >", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerGreaterThanOrEqualTo(String value) {
            addCriterion("organizer >=", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerLessThan(String value) {
            addCriterion("organizer <", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerLessThanOrEqualTo(String value) {
            addCriterion("organizer <=", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerLike(String value) {
            addCriterion("organizer like", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotLike(String value) {
            addCriterion("organizer not like", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerIn(List<String> values) {
            addCriterion("organizer in", values, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotIn(List<String> values) {
            addCriterion("organizer not in", values, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerBetween(String value1, String value2) {
            addCriterion("organizer between", value1, value2, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotBetween(String value1, String value2) {
            addCriterion("organizer not between", value1, value2, "organizer");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeIsNull() {
            addCriterion("current_node is null");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeIsNotNull() {
            addCriterion("current_node is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeEqualTo(String value) {
            addCriterion("current_node =", value, "currentNode");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNotEqualTo(String value) {
            addCriterion("current_node <>", value, "currentNode");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeGreaterThan(String value) {
            addCriterion("current_node >", value, "currentNode");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeGreaterThanOrEqualTo(String value) {
            addCriterion("current_node >=", value, "currentNode");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeLessThan(String value) {
            addCriterion("current_node <", value, "currentNode");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeLessThanOrEqualTo(String value) {
            addCriterion("current_node <=", value, "currentNode");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeLike(String value) {
            addCriterion("current_node like", value, "currentNode");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNotLike(String value) {
            addCriterion("current_node not like", value, "currentNode");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeIn(List<String> values) {
            addCriterion("current_node in", values, "currentNode");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNotIn(List<String> values) {
            addCriterion("current_node not in", values, "currentNode");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeBetween(String value1, String value2) {
            addCriterion("current_node between", value1, value2, "currentNode");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNotBetween(String value1, String value2) {
            addCriterion("current_node not between", value1, value2, "currentNode");
            return (Criteria) this;
        }

        public Criteria andNodeCountIsNull() {
            addCriterion("node_count is null");
            return (Criteria) this;
        }

        public Criteria andNodeCountIsNotNull() {
            addCriterion("node_count is not null");
            return (Criteria) this;
        }

        public Criteria andNodeCountEqualTo(Integer value) {
            addCriterion("node_count =", value, "nodeCount");
            return (Criteria) this;
        }

        public Criteria andNodeCountNotEqualTo(Integer value) {
            addCriterion("node_count <>", value, "nodeCount");
            return (Criteria) this;
        }

        public Criteria andNodeCountGreaterThan(Integer value) {
            addCriterion("node_count >", value, "nodeCount");
            return (Criteria) this;
        }

        public Criteria andNodeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_count >=", value, "nodeCount");
            return (Criteria) this;
        }

        public Criteria andNodeCountLessThan(Integer value) {
            addCriterion("node_count <", value, "nodeCount");
            return (Criteria) this;
        }

        public Criteria andNodeCountLessThanOrEqualTo(Integer value) {
            addCriterion("node_count <=", value, "nodeCount");
            return (Criteria) this;
        }

        public Criteria andNodeCountIn(List<Integer> values) {
            addCriterion("node_count in", values, "nodeCount");
            return (Criteria) this;
        }

        public Criteria andNodeCountNotIn(List<Integer> values) {
            addCriterion("node_count not in", values, "nodeCount");
            return (Criteria) this;
        }

        public Criteria andNodeCountBetween(Integer value1, Integer value2) {
            addCriterion("node_count between", value1, value2, "nodeCount");
            return (Criteria) this;
        }

        public Criteria andNodeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("node_count not between", value1, value2, "nodeCount");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIsNull() {
            addCriterion("operate_time is null");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIsNotNull() {
            addCriterion("operate_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperateTimeEqualTo(Date value) {
            addCriterion("operate_time =", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotEqualTo(Date value) {
            addCriterion("operate_time <>", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeGreaterThan(Date value) {
            addCriterion("operate_time >", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operate_time >=", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeLessThan(Date value) {
            addCriterion("operate_time <", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeLessThanOrEqualTo(Date value) {
            addCriterion("operate_time <=", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIn(List<Date> values) {
            addCriterion("operate_time in", values, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotIn(List<Date> values) {
            addCriterion("operate_time not in", values, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeBetween(Date value1, Date value2) {
            addCriterion("operate_time between", value1, value2, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotBetween(Date value1, Date value2) {
            addCriterion("operate_time not between", value1, value2, "operateTime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusIsNull() {
            addCriterion("work_order_status is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusIsNotNull() {
            addCriterion("work_order_status is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusEqualTo(Integer value) {
            addCriterion("work_order_status =", value, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusNotEqualTo(Integer value) {
            addCriterion("work_order_status <>", value, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusGreaterThan(Integer value) {
            addCriterion("work_order_status >", value, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("work_order_status >=", value, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusLessThan(Integer value) {
            addCriterion("work_order_status <", value, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("work_order_status <=", value, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusIn(List<Integer> values) {
            addCriterion("work_order_status in", values, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusNotIn(List<Integer> values) {
            addCriterion("work_order_status not in", values, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusBetween(Integer value1, Integer value2) {
            addCriterion("work_order_status between", value1, value2, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("work_order_status not between", value1, value2, "workOrderStatus");
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