package com.hbxy.ssm.admin.user.model;

import java.util.ArrayList;
import java.util.List;

public class VipExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public VipExample() {
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

        public Criteria andVIdIsNull() {
            addCriterion("v_id is null");
            return (Criteria) this;
        }

        public Criteria andVIdIsNotNull() {
            addCriterion("v_id is not null");
            return (Criteria) this;
        }

        public Criteria andVIdEqualTo(String value) {
            addCriterion("v_id =", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotEqualTo(String value) {
            addCriterion("v_id <>", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdGreaterThan(String value) {
            addCriterion("v_id >", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdGreaterThanOrEqualTo(String value) {
            addCriterion("v_id >=", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdLessThan(String value) {
            addCriterion("v_id <", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdLessThanOrEqualTo(String value) {
            addCriterion("v_id <=", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdLike(String value) {
            addCriterion("v_id like", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotLike(String value) {
            addCriterion("v_id not like", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdIn(List<String> values) {
            addCriterion("v_id in", values, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotIn(List<String> values) {
            addCriterion("v_id not in", values, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdBetween(String value1, String value2) {
            addCriterion("v_id between", value1, value2, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotBetween(String value1, String value2) {
            addCriterion("v_id not between", value1, value2, "vId");
            return (Criteria) this;
        }

        public Criteria andVNameIsNull() {
            addCriterion("v_name is null");
            return (Criteria) this;
        }

        public Criteria andVNameIsNotNull() {
            addCriterion("v_name is not null");
            return (Criteria) this;
        }

        public Criteria andVNameEqualTo(String value) {
            addCriterion("v_name =", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameNotEqualTo(String value) {
            addCriterion("v_name <>", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameGreaterThan(String value) {
            addCriterion("v_name >", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameGreaterThanOrEqualTo(String value) {
            addCriterion("v_name >=", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameLessThan(String value) {
            addCriterion("v_name <", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameLessThanOrEqualTo(String value) {
            addCriterion("v_name <=", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameLike(String value) {
            addCriterion("v_name like", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameNotLike(String value) {
            addCriterion("v_name not like", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameIn(List<String> values) {
            addCriterion("v_name in", values, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameNotIn(List<String> values) {
            addCriterion("v_name not in", values, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameBetween(String value1, String value2) {
            addCriterion("v_name between", value1, value2, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameNotBetween(String value1, String value2) {
            addCriterion("v_name not between", value1, value2, "vName");
            return (Criteria) this;
        }

        public Criteria andVSexIsNull() {
            addCriterion("v_sex is null");
            return (Criteria) this;
        }

        public Criteria andVSexIsNotNull() {
            addCriterion("v_sex is not null");
            return (Criteria) this;
        }

        public Criteria andVSexEqualTo(String value) {
            addCriterion("v_sex =", value, "vSex");
            return (Criteria) this;
        }

        public Criteria andVSexNotEqualTo(String value) {
            addCriterion("v_sex <>", value, "vSex");
            return (Criteria) this;
        }

        public Criteria andVSexGreaterThan(String value) {
            addCriterion("v_sex >", value, "vSex");
            return (Criteria) this;
        }

        public Criteria andVSexGreaterThanOrEqualTo(String value) {
            addCriterion("v_sex >=", value, "vSex");
            return (Criteria) this;
        }

        public Criteria andVSexLessThan(String value) {
            addCriterion("v_sex <", value, "vSex");
            return (Criteria) this;
        }

        public Criteria andVSexLessThanOrEqualTo(String value) {
            addCriterion("v_sex <=", value, "vSex");
            return (Criteria) this;
        }

        public Criteria andVSexLike(String value) {
            addCriterion("v_sex like", value, "vSex");
            return (Criteria) this;
        }

        public Criteria andVSexNotLike(String value) {
            addCriterion("v_sex not like", value, "vSex");
            return (Criteria) this;
        }

        public Criteria andVSexIn(List<String> values) {
            addCriterion("v_sex in", values, "vSex");
            return (Criteria) this;
        }

        public Criteria andVSexNotIn(List<String> values) {
            addCriterion("v_sex not in", values, "vSex");
            return (Criteria) this;
        }

        public Criteria andVSexBetween(String value1, String value2) {
            addCriterion("v_sex between", value1, value2, "vSex");
            return (Criteria) this;
        }

        public Criteria andVSexNotBetween(String value1, String value2) {
            addCriterion("v_sex not between", value1, value2, "vSex");
            return (Criteria) this;
        }

        public Criteria andVPhoneIsNull() {
            addCriterion("v_phone is null");
            return (Criteria) this;
        }

        public Criteria andVPhoneIsNotNull() {
            addCriterion("v_phone is not null");
            return (Criteria) this;
        }

        public Criteria andVPhoneEqualTo(String value) {
            addCriterion("v_phone =", value, "vPhone");
            return (Criteria) this;
        }

        public Criteria andVPhoneNotEqualTo(String value) {
            addCriterion("v_phone <>", value, "vPhone");
            return (Criteria) this;
        }

        public Criteria andVPhoneGreaterThan(String value) {
            addCriterion("v_phone >", value, "vPhone");
            return (Criteria) this;
        }

        public Criteria andVPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("v_phone >=", value, "vPhone");
            return (Criteria) this;
        }

        public Criteria andVPhoneLessThan(String value) {
            addCriterion("v_phone <", value, "vPhone");
            return (Criteria) this;
        }

        public Criteria andVPhoneLessThanOrEqualTo(String value) {
            addCriterion("v_phone <=", value, "vPhone");
            return (Criteria) this;
        }

        public Criteria andVPhoneLike(String value) {
            addCriterion("v_phone like", value, "vPhone");
            return (Criteria) this;
        }

        public Criteria andVPhoneNotLike(String value) {
            addCriterion("v_phone not like", value, "vPhone");
            return (Criteria) this;
        }

        public Criteria andVPhoneIn(List<String> values) {
            addCriterion("v_phone in", values, "vPhone");
            return (Criteria) this;
        }

        public Criteria andVPhoneNotIn(List<String> values) {
            addCriterion("v_phone not in", values, "vPhone");
            return (Criteria) this;
        }

        public Criteria andVPhoneBetween(String value1, String value2) {
            addCriterion("v_phone between", value1, value2, "vPhone");
            return (Criteria) this;
        }

        public Criteria andVPhoneNotBetween(String value1, String value2) {
            addCriterion("v_phone not between", value1, value2, "vPhone");
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