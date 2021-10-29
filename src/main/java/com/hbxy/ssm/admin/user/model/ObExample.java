package com.hbxy.ssm.admin.user.model;

import java.util.ArrayList;
import java.util.List;

public class ObExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ObExample() {
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

        public Criteria andOIdIsNull() {
            addCriterion("o_id is null");
            return (Criteria) this;
        }

        public Criteria andOIdIsNotNull() {
            addCriterion("o_id is not null");
            return (Criteria) this;
        }

        public Criteria andOIdEqualTo(String value) {
            addCriterion("o_id =", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotEqualTo(String value) {
            addCriterion("o_id <>", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThan(String value) {
            addCriterion("o_id >", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThanOrEqualTo(String value) {
            addCriterion("o_id >=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThan(String value) {
            addCriterion("o_id <", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThanOrEqualTo(String value) {
            addCriterion("o_id <=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLike(String value) {
            addCriterion("o_id like", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotLike(String value) {
            addCriterion("o_id not like", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdIn(List<String> values) {
            addCriterion("o_id in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotIn(List<String> values) {
            addCriterion("o_id not in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdBetween(String value1, String value2) {
            addCriterion("o_id between", value1, value2, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotBetween(String value1, String value2) {
            addCriterion("o_id not between", value1, value2, "oId");
            return (Criteria) this;
        }

        public Criteria andONameIsNull() {
            addCriterion("o_name is null");
            return (Criteria) this;
        }

        public Criteria andONameIsNotNull() {
            addCriterion("o_name is not null");
            return (Criteria) this;
        }

        public Criteria andONameEqualTo(String value) {
            addCriterion("o_name =", value, "oName");
            return (Criteria) this;
        }

        public Criteria andONameNotEqualTo(String value) {
            addCriterion("o_name <>", value, "oName");
            return (Criteria) this;
        }

        public Criteria andONameGreaterThan(String value) {
            addCriterion("o_name >", value, "oName");
            return (Criteria) this;
        }

        public Criteria andONameGreaterThanOrEqualTo(String value) {
            addCriterion("o_name >=", value, "oName");
            return (Criteria) this;
        }

        public Criteria andONameLessThan(String value) {
            addCriterion("o_name <", value, "oName");
            return (Criteria) this;
        }

        public Criteria andONameLessThanOrEqualTo(String value) {
            addCriterion("o_name <=", value, "oName");
            return (Criteria) this;
        }

        public Criteria andONameLike(String value) {
            addCriterion("o_name like", value, "oName");
            return (Criteria) this;
        }

        public Criteria andONameNotLike(String value) {
            addCriterion("o_name not like", value, "oName");
            return (Criteria) this;
        }

        public Criteria andONameIn(List<String> values) {
            addCriterion("o_name in", values, "oName");
            return (Criteria) this;
        }

        public Criteria andONameNotIn(List<String> values) {
            addCriterion("o_name not in", values, "oName");
            return (Criteria) this;
        }

        public Criteria andONameBetween(String value1, String value2) {
            addCriterion("o_name between", value1, value2, "oName");
            return (Criteria) this;
        }

        public Criteria andONameNotBetween(String value1, String value2) {
            addCriterion("o_name not between", value1, value2, "oName");
            return (Criteria) this;
        }

        public Criteria andOCountIsNull() {
            addCriterion("o_count is null");
            return (Criteria) this;
        }

        public Criteria andOCountIsNotNull() {
            addCriterion("o_count is not null");
            return (Criteria) this;
        }

        public Criteria andOCountEqualTo(Integer value) {
            addCriterion("o_count =", value, "oCount");
            return (Criteria) this;
        }

        public Criteria andOCountNotEqualTo(Integer value) {
            addCriterion("o_count <>", value, "oCount");
            return (Criteria) this;
        }

        public Criteria andOCountGreaterThan(Integer value) {
            addCriterion("o_count >", value, "oCount");
            return (Criteria) this;
        }

        public Criteria andOCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("o_count >=", value, "oCount");
            return (Criteria) this;
        }

        public Criteria andOCountLessThan(Integer value) {
            addCriterion("o_count <", value, "oCount");
            return (Criteria) this;
        }

        public Criteria andOCountLessThanOrEqualTo(Integer value) {
            addCriterion("o_count <=", value, "oCount");
            return (Criteria) this;
        }

        public Criteria andOCountIn(List<Integer> values) {
            addCriterion("o_count in", values, "oCount");
            return (Criteria) this;
        }

        public Criteria andOCountNotIn(List<Integer> values) {
            addCriterion("o_count not in", values, "oCount");
            return (Criteria) this;
        }

        public Criteria andOCountBetween(Integer value1, Integer value2) {
            addCriterion("o_count between", value1, value2, "oCount");
            return (Criteria) this;
        }

        public Criteria andOCountNotBetween(Integer value1, Integer value2) {
            addCriterion("o_count not between", value1, value2, "oCount");
            return (Criteria) this;
        }

        public Criteria andOPriceIsNull() {
            addCriterion("o_price is null");
            return (Criteria) this;
        }

        public Criteria andOPriceIsNotNull() {
            addCriterion("o_price is not null");
            return (Criteria) this;
        }

        public Criteria andOPriceEqualTo(Float value) {
            addCriterion("o_price =", value, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceNotEqualTo(Float value) {
            addCriterion("o_price <>", value, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceGreaterThan(Float value) {
            addCriterion("o_price >", value, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("o_price >=", value, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceLessThan(Float value) {
            addCriterion("o_price <", value, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceLessThanOrEqualTo(Float value) {
            addCriterion("o_price <=", value, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceIn(List<Float> values) {
            addCriterion("o_price in", values, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceNotIn(List<Float> values) {
            addCriterion("o_price not in", values, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceBetween(Float value1, Float value2) {
            addCriterion("o_price between", value1, value2, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceNotBetween(Float value1, Float value2) {
            addCriterion("o_price not between", value1, value2, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOFactoryIsNull() {
            addCriterion("o_factory is null");
            return (Criteria) this;
        }

        public Criteria andOFactoryIsNotNull() {
            addCriterion("o_factory is not null");
            return (Criteria) this;
        }

        public Criteria andOFactoryEqualTo(String value) {
            addCriterion("o_factory =", value, "oFactory");
            return (Criteria) this;
        }

        public Criteria andOFactoryNotEqualTo(String value) {
            addCriterion("o_factory <>", value, "oFactory");
            return (Criteria) this;
        }

        public Criteria andOFactoryGreaterThan(String value) {
            addCriterion("o_factory >", value, "oFactory");
            return (Criteria) this;
        }

        public Criteria andOFactoryGreaterThanOrEqualTo(String value) {
            addCriterion("o_factory >=", value, "oFactory");
            return (Criteria) this;
        }

        public Criteria andOFactoryLessThan(String value) {
            addCriterion("o_factory <", value, "oFactory");
            return (Criteria) this;
        }

        public Criteria andOFactoryLessThanOrEqualTo(String value) {
            addCriterion("o_factory <=", value, "oFactory");
            return (Criteria) this;
        }

        public Criteria andOFactoryLike(String value) {
            addCriterion("o_factory like", value, "oFactory");
            return (Criteria) this;
        }

        public Criteria andOFactoryNotLike(String value) {
            addCriterion("o_factory not like", value, "oFactory");
            return (Criteria) this;
        }

        public Criteria andOFactoryIn(List<String> values) {
            addCriterion("o_factory in", values, "oFactory");
            return (Criteria) this;
        }

        public Criteria andOFactoryNotIn(List<String> values) {
            addCriterion("o_factory not in", values, "oFactory");
            return (Criteria) this;
        }

        public Criteria andOFactoryBetween(String value1, String value2) {
            addCriterion("o_factory between", value1, value2, "oFactory");
            return (Criteria) this;
        }

        public Criteria andOFactoryNotBetween(String value1, String value2) {
            addCriterion("o_factory not between", value1, value2, "oFactory");
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