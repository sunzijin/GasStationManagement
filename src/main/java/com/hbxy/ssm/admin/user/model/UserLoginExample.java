package com.hbxy.ssm.admin.user.model;

import java.util.ArrayList;
import java.util.List;

public class UserLoginExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public UserLoginExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserLoginIdIsNull() {
            addCriterion("user_login_id is null");
            return (Criteria) this;
        }

        public Criteria andUserLoginIdIsNotNull() {
            addCriterion("user_login_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserLoginIdEqualTo(String value) {
            addCriterion("user_login_id =", value, "userLoginId");
            return (Criteria) this;
        }

        public Criteria andUserLoginIdNotEqualTo(String value) {
            addCriterion("user_login_id <>", value, "userLoginId");
            return (Criteria) this;
        }

        public Criteria andUserLoginIdGreaterThan(String value) {
            addCriterion("user_login_id >", value, "userLoginId");
            return (Criteria) this;
        }

        public Criteria andUserLoginIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_login_id >=", value, "userLoginId");
            return (Criteria) this;
        }

        public Criteria andUserLoginIdLessThan(String value) {
            addCriterion("user_login_id <", value, "userLoginId");
            return (Criteria) this;
        }

        public Criteria andUserLoginIdLessThanOrEqualTo(String value) {
            addCriterion("user_login_id <=", value, "userLoginId");
            return (Criteria) this;
        }

        public Criteria andUserLoginIdLike(String value) {
            addCriterion("user_login_id like", value, "userLoginId");
            return (Criteria) this;
        }

        public Criteria andUserLoginIdNotLike(String value) {
            addCriterion("user_login_id not like", value, "userLoginId");
            return (Criteria) this;
        }

        public Criteria andUserLoginIdIn(List<String> values) {
            addCriterion("user_login_id in", values, "userLoginId");
            return (Criteria) this;
        }

        public Criteria andUserLoginIdNotIn(List<String> values) {
            addCriterion("user_login_id not in", values, "userLoginId");
            return (Criteria) this;
        }

        public Criteria andUserLoginIdBetween(String value1, String value2) {
            addCriterion("user_login_id between", value1, value2, "userLoginId");
            return (Criteria) this;
        }

        public Criteria andUserLoginIdNotBetween(String value1, String value2) {
            addCriterion("user_login_id not between", value1, value2, "userLoginId");
            return (Criteria) this;
        }

        public Criteria andCurrentPasswordIsNull() {
            addCriterion("current_password is null");
            return (Criteria) this;
        }

        public Criteria andCurrentPasswordIsNotNull() {
            addCriterion("current_password is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentPasswordEqualTo(String value) {
            addCriterion("current_password =", value, "currentPassword");
            return (Criteria) this;
        }

        public Criteria andCurrentPasswordNotEqualTo(String value) {
            addCriterion("current_password <>", value, "currentPassword");
            return (Criteria) this;
        }

        public Criteria andCurrentPasswordGreaterThan(String value) {
            addCriterion("current_password >", value, "currentPassword");
            return (Criteria) this;
        }

        public Criteria andCurrentPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("current_password >=", value, "currentPassword");
            return (Criteria) this;
        }

        public Criteria andCurrentPasswordLessThan(String value) {
            addCriterion("current_password <", value, "currentPassword");
            return (Criteria) this;
        }

        public Criteria andCurrentPasswordLessThanOrEqualTo(String value) {
            addCriterion("current_password <=", value, "currentPassword");
            return (Criteria) this;
        }

        public Criteria andCurrentPasswordLike(String value) {
            addCriterion("current_password like", value, "currentPassword");
            return (Criteria) this;
        }

        public Criteria andCurrentPasswordNotLike(String value) {
            addCriterion("current_password not like", value, "currentPassword");
            return (Criteria) this;
        }

        public Criteria andCurrentPasswordIn(List<String> values) {
            addCriterion("current_password in", values, "currentPassword");
            return (Criteria) this;
        }

        public Criteria andCurrentPasswordNotIn(List<String> values) {
            addCriterion("current_password not in", values, "currentPassword");
            return (Criteria) this;
        }

        public Criteria andCurrentPasswordBetween(String value1, String value2) {
            addCriterion("current_password between", value1, value2, "currentPassword");
            return (Criteria) this;
        }

        public Criteria andCurrentPasswordNotBetween(String value1, String value2) {
            addCriterion("current_password not between", value1, value2, "currentPassword");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("user_type like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("user_type not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andMSexIsNull() {
            addCriterion("m_sex is null");
            return (Criteria) this;
        }

        public Criteria andMSexIsNotNull() {
            addCriterion("m_sex is not null");
            return (Criteria) this;
        }

        public Criteria andMSexEqualTo(String value) {
            addCriterion("m_sex =", value, "mSex");
            return (Criteria) this;
        }

        public Criteria andMSexNotEqualTo(String value) {
            addCriterion("m_sex <>", value, "mSex");
            return (Criteria) this;
        }

        public Criteria andMSexGreaterThan(String value) {
            addCriterion("m_sex >", value, "mSex");
            return (Criteria) this;
        }

        public Criteria andMSexGreaterThanOrEqualTo(String value) {
            addCriterion("m_sex >=", value, "mSex");
            return (Criteria) this;
        }

        public Criteria andMSexLessThan(String value) {
            addCriterion("m_sex <", value, "mSex");
            return (Criteria) this;
        }

        public Criteria andMSexLessThanOrEqualTo(String value) {
            addCriterion("m_sex <=", value, "mSex");
            return (Criteria) this;
        }

        public Criteria andMSexLike(String value) {
            addCriterion("m_sex like", value, "mSex");
            return (Criteria) this;
        }

        public Criteria andMSexNotLike(String value) {
            addCriterion("m_sex not like", value, "mSex");
            return (Criteria) this;
        }

        public Criteria andMSexIn(List<String> values) {
            addCriterion("m_sex in", values, "mSex");
            return (Criteria) this;
        }

        public Criteria andMSexNotIn(List<String> values) {
            addCriterion("m_sex not in", values, "mSex");
            return (Criteria) this;
        }

        public Criteria andMSexBetween(String value1, String value2) {
            addCriterion("m_sex between", value1, value2, "mSex");
            return (Criteria) this;
        }

        public Criteria andMSexNotBetween(String value1, String value2) {
            addCriterion("m_sex not between", value1, value2, "mSex");
            return (Criteria) this;
        }

        public Criteria andMAgeIsNull() {
            addCriterion("m_age is null");
            return (Criteria) this;
        }

        public Criteria andMAgeIsNotNull() {
            addCriterion("m_age is not null");
            return (Criteria) this;
        }

        public Criteria andMAgeEqualTo(Integer value) {
            addCriterion("m_age =", value, "mAge");
            return (Criteria) this;
        }

        public Criteria andMAgeNotEqualTo(Integer value) {
            addCriterion("m_age <>", value, "mAge");
            return (Criteria) this;
        }

        public Criteria andMAgeGreaterThan(Integer value) {
            addCriterion("m_age >", value, "mAge");
            return (Criteria) this;
        }

        public Criteria andMAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_age >=", value, "mAge");
            return (Criteria) this;
        }

        public Criteria andMAgeLessThan(Integer value) {
            addCriterion("m_age <", value, "mAge");
            return (Criteria) this;
        }

        public Criteria andMAgeLessThanOrEqualTo(Integer value) {
            addCriterion("m_age <=", value, "mAge");
            return (Criteria) this;
        }

        public Criteria andMAgeIn(List<Integer> values) {
            addCriterion("m_age in", values, "mAge");
            return (Criteria) this;
        }

        public Criteria andMAgeNotIn(List<Integer> values) {
            addCriterion("m_age not in", values, "mAge");
            return (Criteria) this;
        }

        public Criteria andMAgeBetween(Integer value1, Integer value2) {
            addCriterion("m_age between", value1, value2, "mAge");
            return (Criteria) this;
        }

        public Criteria andMAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("m_age not between", value1, value2, "mAge");
            return (Criteria) this;
        }

        public Criteria andMMoneyIsNull() {
            addCriterion("m_money is null");
            return (Criteria) this;
        }

        public Criteria andMMoneyIsNotNull() {
            addCriterion("m_money is not null");
            return (Criteria) this;
        }

        public Criteria andMMoneyEqualTo(Float value) {
            addCriterion("m_money =", value, "mMoney");
            return (Criteria) this;
        }

        public Criteria andMMoneyNotEqualTo(Float value) {
            addCriterion("m_money <>", value, "mMoney");
            return (Criteria) this;
        }

        public Criteria andMMoneyGreaterThan(Float value) {
            addCriterion("m_money >", value, "mMoney");
            return (Criteria) this;
        }

        public Criteria andMMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("m_money >=", value, "mMoney");
            return (Criteria) this;
        }

        public Criteria andMMoneyLessThan(Float value) {
            addCriterion("m_money <", value, "mMoney");
            return (Criteria) this;
        }

        public Criteria andMMoneyLessThanOrEqualTo(Float value) {
            addCriterion("m_money <=", value, "mMoney");
            return (Criteria) this;
        }

        public Criteria andMMoneyIn(List<Float> values) {
            addCriterion("m_money in", values, "mMoney");
            return (Criteria) this;
        }

        public Criteria andMMoneyNotIn(List<Float> values) {
            addCriterion("m_money not in", values, "mMoney");
            return (Criteria) this;
        }

        public Criteria andMMoneyBetween(Float value1, Float value2) {
            addCriterion("m_money between", value1, value2, "mMoney");
            return (Criteria) this;
        }

        public Criteria andMMoneyNotBetween(Float value1, Float value2) {
            addCriterion("m_money not between", value1, value2, "mMoney");
            return (Criteria) this;
        }

        public Criteria andMPhoneIsNull() {
            addCriterion("m_phone is null");
            return (Criteria) this;
        }

        public Criteria andMPhoneIsNotNull() {
            addCriterion("m_phone is not null");
            return (Criteria) this;
        }

        public Criteria andMPhoneEqualTo(String value) {
            addCriterion("m_phone =", value, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneNotEqualTo(String value) {
            addCriterion("m_phone <>", value, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneGreaterThan(String value) {
            addCriterion("m_phone >", value, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("m_phone >=", value, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneLessThan(String value) {
            addCriterion("m_phone <", value, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneLessThanOrEqualTo(String value) {
            addCriterion("m_phone <=", value, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneLike(String value) {
            addCriterion("m_phone like", value, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneNotLike(String value) {
            addCriterion("m_phone not like", value, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneIn(List<String> values) {
            addCriterion("m_phone in", values, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneNotIn(List<String> values) {
            addCriterion("m_phone not in", values, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneBetween(String value1, String value2) {
            addCriterion("m_phone between", value1, value2, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneNotBetween(String value1, String value2) {
            addCriterion("m_phone not between", value1, value2, "mPhone");
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