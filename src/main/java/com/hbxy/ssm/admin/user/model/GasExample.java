package com.hbxy.ssm.admin.user.model;

import java.util.ArrayList;
import java.util.List;

public class GasExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public GasExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andGIdIsNull() {
            addCriterion("g_id is null");
            return (Criteria) this;
        }

        public Criteria andGIdIsNotNull() {
            addCriterion("g_id is not null");
            return (Criteria) this;
        }

        public Criteria andGIdEqualTo(String value) {
            addCriterion("g_id =", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdNotEqualTo(String value) {
            addCriterion("g_id <>", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdGreaterThan(String value) {
            addCriterion("g_id >", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdGreaterThanOrEqualTo(String value) {
            addCriterion("g_id >=", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdLessThan(String value) {
            addCriterion("g_id <", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdLessThanOrEqualTo(String value) {
            addCriterion("g_id <=", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdLike(String value) {
            addCriterion("g_id like", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdNotLike(String value) {
            addCriterion("g_id not like", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdIn(List<String> values) {
            addCriterion("g_id in", values, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdNotIn(List<String> values) {
            addCriterion("g_id not in", values, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdBetween(String value1, String value2) {
            addCriterion("g_id between", value1, value2, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdNotBetween(String value1, String value2) {
            addCriterion("g_id not between", value1, value2, "gId");
            return (Criteria) this;
        }

        public Criteria andGNameIsNull() {
            addCriterion("g_name is null");
            return (Criteria) this;
        }

        public Criteria andGNameIsNotNull() {
            addCriterion("g_name is not null");
            return (Criteria) this;
        }

        public Criteria andGNameEqualTo(String value) {
            addCriterion("g_name =", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotEqualTo(String value) {
            addCriterion("g_name <>", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameGreaterThan(String value) {
            addCriterion("g_name >", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameGreaterThanOrEqualTo(String value) {
            addCriterion("g_name >=", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLessThan(String value) {
            addCriterion("g_name <", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLessThanOrEqualTo(String value) {
            addCriterion("g_name <=", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLike(String value) {
            addCriterion("g_name like", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotLike(String value) {
            addCriterion("g_name not like", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameIn(List<String> values) {
            addCriterion("g_name in", values, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotIn(List<String> values) {
            addCriterion("g_name not in", values, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameBetween(String value1, String value2) {
            addCriterion("g_name between", value1, value2, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotBetween(String value1, String value2) {
            addCriterion("g_name not between", value1, value2, "gName");
            return (Criteria) this;
        }

        public Criteria andGTypeIsNull() {
            addCriterion("g_type is null");
            return (Criteria) this;
        }

        public Criteria andGTypeIsNotNull() {
            addCriterion("g_type is not null");
            return (Criteria) this;
        }

        public Criteria andGTypeEqualTo(String value) {
            addCriterion("g_type =", value, "gType");
            return (Criteria) this;
        }

        public Criteria andGTypeNotEqualTo(String value) {
            addCriterion("g_type <>", value, "gType");
            return (Criteria) this;
        }

        public Criteria andGTypeGreaterThan(String value) {
            addCriterion("g_type >", value, "gType");
            return (Criteria) this;
        }

        public Criteria andGTypeGreaterThanOrEqualTo(String value) {
            addCriterion("g_type >=", value, "gType");
            return (Criteria) this;
        }

        public Criteria andGTypeLessThan(String value) {
            addCriterion("g_type <", value, "gType");
            return (Criteria) this;
        }

        public Criteria andGTypeLessThanOrEqualTo(String value) {
            addCriterion("g_type <=", value, "gType");
            return (Criteria) this;
        }

        public Criteria andGTypeLike(String value) {
            addCriterion("g_type like", value, "gType");
            return (Criteria) this;
        }

        public Criteria andGTypeNotLike(String value) {
            addCriterion("g_type not like", value, "gType");
            return (Criteria) this;
        }

        public Criteria andGTypeIn(List<String> values) {
            addCriterion("g_type in", values, "gType");
            return (Criteria) this;
        }

        public Criteria andGTypeNotIn(List<String> values) {
            addCriterion("g_type not in", values, "gType");
            return (Criteria) this;
        }

        public Criteria andGTypeBetween(String value1, String value2) {
            addCriterion("g_type between", value1, value2, "gType");
            return (Criteria) this;
        }

        public Criteria andGTypeNotBetween(String value1, String value2) {
            addCriterion("g_type not between", value1, value2, "gType");
            return (Criteria) this;
        }

        public Criteria andGUMoneyIsNull() {
            addCriterion("g_u_money is null");
            return (Criteria) this;
        }

        public Criteria andGUMoneyIsNotNull() {
            addCriterion("g_u_money is not null");
            return (Criteria) this;
        }

        public Criteria andGUMoneyEqualTo(Float value) {
            addCriterion("g_u_money =", value, "gUMoney");
            return (Criteria) this;
        }

        public Criteria andGUMoneyNotEqualTo(Float value) {
            addCriterion("g_u_money <>", value, "gUMoney");
            return (Criteria) this;
        }

        public Criteria andGUMoneyGreaterThan(Float value) {
            addCriterion("g_u_money >", value, "gUMoney");
            return (Criteria) this;
        }

        public Criteria andGUMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("g_u_money >=", value, "gUMoney");
            return (Criteria) this;
        }

        public Criteria andGUMoneyLessThan(Float value) {
            addCriterion("g_u_money <", value, "gUMoney");
            return (Criteria) this;
        }

        public Criteria andGUMoneyLessThanOrEqualTo(Float value) {
            addCriterion("g_u_money <=", value, "gUMoney");
            return (Criteria) this;
        }

        public Criteria andGUMoneyIn(List<Float> values) {
            addCriterion("g_u_money in", values, "gUMoney");
            return (Criteria) this;
        }

        public Criteria andGUMoneyNotIn(List<Float> values) {
            addCriterion("g_u_money not in", values, "gUMoney");
            return (Criteria) this;
        }

        public Criteria andGUMoneyBetween(Float value1, Float value2) {
            addCriterion("g_u_money between", value1, value2, "gUMoney");
            return (Criteria) this;
        }

        public Criteria andGUMoneyNotBetween(Float value1, Float value2) {
            addCriterion("g_u_money not between", value1, value2, "gUMoney");
            return (Criteria) this;
        }

        public Criteria andGVMoneyIsNull() {
            addCriterion("g_v_money is null");
            return (Criteria) this;
        }

        public Criteria andGVMoneyIsNotNull() {
            addCriterion("g_v_money is not null");
            return (Criteria) this;
        }

        public Criteria andGVMoneyEqualTo(Float value) {
            addCriterion("g_v_money =", value, "gVMoney");
            return (Criteria) this;
        }

        public Criteria andGVMoneyNotEqualTo(Float value) {
            addCriterion("g_v_money <>", value, "gVMoney");
            return (Criteria) this;
        }

        public Criteria andGVMoneyGreaterThan(Float value) {
            addCriterion("g_v_money >", value, "gVMoney");
            return (Criteria) this;
        }

        public Criteria andGVMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("g_v_money >=", value, "gVMoney");
            return (Criteria) this;
        }

        public Criteria andGVMoneyLessThan(Float value) {
            addCriterion("g_v_money <", value, "gVMoney");
            return (Criteria) this;
        }

        public Criteria andGVMoneyLessThanOrEqualTo(Float value) {
            addCriterion("g_v_money <=", value, "gVMoney");
            return (Criteria) this;
        }

        public Criteria andGVMoneyIn(List<Float> values) {
            addCriterion("g_v_money in", values, "gVMoney");
            return (Criteria) this;
        }

        public Criteria andGVMoneyNotIn(List<Float> values) {
            addCriterion("g_v_money not in", values, "gVMoney");
            return (Criteria) this;
        }

        public Criteria andGVMoneyBetween(Float value1, Float value2) {
            addCriterion("g_v_money between", value1, value2, "gVMoney");
            return (Criteria) this;
        }

        public Criteria andGVMoneyNotBetween(Float value1, Float value2) {
            addCriterion("g_v_money not between", value1, value2, "gVMoney");
            return (Criteria) this;
        }
    }

    /**
     */
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