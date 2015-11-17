package com.weichat.boss.data.pojo;

import java.util.ArrayList;
import java.util.List;

public class VoteRecordExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_vote_record
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_vote_record
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_vote_record
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_record
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    public VoteRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_record
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_record
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_record
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_record
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_record
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_record
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_record
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_record
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_record
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_record
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_vote_record
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andVoteidIsNull() {
            addCriterion("voteId is null");
            return (Criteria) this;
        }

        public Criteria andVoteidIsNotNull() {
            addCriterion("voteId is not null");
            return (Criteria) this;
        }

        public Criteria andVoteidEqualTo(Integer value) {
            addCriterion("voteId =", value, "voteid");
            return (Criteria) this;
        }

        public Criteria andVoteidNotEqualTo(Integer value) {
            addCriterion("voteId <>", value, "voteid");
            return (Criteria) this;
        }

        public Criteria andVoteidGreaterThan(Integer value) {
            addCriterion("voteId >", value, "voteid");
            return (Criteria) this;
        }

        public Criteria andVoteidGreaterThanOrEqualTo(Integer value) {
            addCriterion("voteId >=", value, "voteid");
            return (Criteria) this;
        }

        public Criteria andVoteidLessThan(Integer value) {
            addCriterion("voteId <", value, "voteid");
            return (Criteria) this;
        }

        public Criteria andVoteidLessThanOrEqualTo(Integer value) {
            addCriterion("voteId <=", value, "voteid");
            return (Criteria) this;
        }

        public Criteria andVoteidIn(List<Integer> values) {
            addCriterion("voteId in", values, "voteid");
            return (Criteria) this;
        }

        public Criteria andVoteidNotIn(List<Integer> values) {
            addCriterion("voteId not in", values, "voteid");
            return (Criteria) this;
        }

        public Criteria andVoteidBetween(Integer value1, Integer value2) {
            addCriterion("voteId between", value1, value2, "voteid");
            return (Criteria) this;
        }

        public Criteria andVoteidNotBetween(Integer value1, Integer value2) {
            addCriterion("voteId not between", value1, value2, "voteid");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidIsNull() {
            addCriterion("voteOptionId is null");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidIsNotNull() {
            addCriterion("voteOptionId is not null");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidEqualTo(Integer value) {
            addCriterion("voteOptionId =", value, "voteoptionid");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidNotEqualTo(Integer value) {
            addCriterion("voteOptionId <>", value, "voteoptionid");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidGreaterThan(Integer value) {
            addCriterion("voteOptionId >", value, "voteoptionid");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("voteOptionId >=", value, "voteoptionid");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidLessThan(Integer value) {
            addCriterion("voteOptionId <", value, "voteoptionid");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidLessThanOrEqualTo(Integer value) {
            addCriterion("voteOptionId <=", value, "voteoptionid");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidIn(List<Integer> values) {
            addCriterion("voteOptionId in", values, "voteoptionid");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidNotIn(List<Integer> values) {
            addCriterion("voteOptionId not in", values, "voteoptionid");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidBetween(Integer value1, Integer value2) {
            addCriterion("voteOptionId between", value1, value2, "voteoptionid");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidNotBetween(Integer value1, Integer value2) {
            addCriterion("voteOptionId not between", value1, value2, "voteoptionid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userId like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userId not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andVotetimeIsNull() {
            addCriterion("voteTime is null");
            return (Criteria) this;
        }

        public Criteria andVotetimeIsNotNull() {
            addCriterion("voteTime is not null");
            return (Criteria) this;
        }

        public Criteria andVotetimeEqualTo(String value) {
            addCriterion("voteTime =", value, "votetime");
            return (Criteria) this;
        }

        public Criteria andVotetimeNotEqualTo(String value) {
            addCriterion("voteTime <>", value, "votetime");
            return (Criteria) this;
        }

        public Criteria andVotetimeGreaterThan(String value) {
            addCriterion("voteTime >", value, "votetime");
            return (Criteria) this;
        }

        public Criteria andVotetimeGreaterThanOrEqualTo(String value) {
            addCriterion("voteTime >=", value, "votetime");
            return (Criteria) this;
        }

        public Criteria andVotetimeLessThan(String value) {
            addCriterion("voteTime <", value, "votetime");
            return (Criteria) this;
        }

        public Criteria andVotetimeLessThanOrEqualTo(String value) {
            addCriterion("voteTime <=", value, "votetime");
            return (Criteria) this;
        }

        public Criteria andVotetimeLike(String value) {
            addCriterion("voteTime like", value, "votetime");
            return (Criteria) this;
        }

        public Criteria andVotetimeNotLike(String value) {
            addCriterion("voteTime not like", value, "votetime");
            return (Criteria) this;
        }

        public Criteria andVotetimeIn(List<String> values) {
            addCriterion("voteTime in", values, "votetime");
            return (Criteria) this;
        }

        public Criteria andVotetimeNotIn(List<String> values) {
            addCriterion("voteTime not in", values, "votetime");
            return (Criteria) this;
        }

        public Criteria andVotetimeBetween(String value1, String value2) {
            addCriterion("voteTime between", value1, value2, "votetime");
            return (Criteria) this;
        }

        public Criteria andVotetimeNotBetween(String value1, String value2) {
            addCriterion("voteTime not between", value1, value2, "votetime");
            return (Criteria) this;
        }

        public Criteria andBackup1IsNull() {
            addCriterion("backup1 is null");
            return (Criteria) this;
        }

        public Criteria andBackup1IsNotNull() {
            addCriterion("backup1 is not null");
            return (Criteria) this;
        }

        public Criteria andBackup1EqualTo(String value) {
            addCriterion("backup1 =", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1NotEqualTo(String value) {
            addCriterion("backup1 <>", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1GreaterThan(String value) {
            addCriterion("backup1 >", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1GreaterThanOrEqualTo(String value) {
            addCriterion("backup1 >=", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1LessThan(String value) {
            addCriterion("backup1 <", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1LessThanOrEqualTo(String value) {
            addCriterion("backup1 <=", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1Like(String value) {
            addCriterion("backup1 like", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1NotLike(String value) {
            addCriterion("backup1 not like", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1In(List<String> values) {
            addCriterion("backup1 in", values, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1NotIn(List<String> values) {
            addCriterion("backup1 not in", values, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1Between(String value1, String value2) {
            addCriterion("backup1 between", value1, value2, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1NotBetween(String value1, String value2) {
            addCriterion("backup1 not between", value1, value2, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup2IsNull() {
            addCriterion("backup2 is null");
            return (Criteria) this;
        }

        public Criteria andBackup2IsNotNull() {
            addCriterion("backup2 is not null");
            return (Criteria) this;
        }

        public Criteria andBackup2EqualTo(String value) {
            addCriterion("backup2 =", value, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup2NotEqualTo(String value) {
            addCriterion("backup2 <>", value, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup2GreaterThan(String value) {
            addCriterion("backup2 >", value, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup2GreaterThanOrEqualTo(String value) {
            addCriterion("backup2 >=", value, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup2LessThan(String value) {
            addCriterion("backup2 <", value, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup2LessThanOrEqualTo(String value) {
            addCriterion("backup2 <=", value, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup2Like(String value) {
            addCriterion("backup2 like", value, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup2NotLike(String value) {
            addCriterion("backup2 not like", value, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup2In(List<String> values) {
            addCriterion("backup2 in", values, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup2NotIn(List<String> values) {
            addCriterion("backup2 not in", values, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup2Between(String value1, String value2) {
            addCriterion("backup2 between", value1, value2, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup2NotBetween(String value1, String value2) {
            addCriterion("backup2 not between", value1, value2, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup3IsNull() {
            addCriterion("backup3 is null");
            return (Criteria) this;
        }

        public Criteria andBackup3IsNotNull() {
            addCriterion("backup3 is not null");
            return (Criteria) this;
        }

        public Criteria andBackup3EqualTo(String value) {
            addCriterion("backup3 =", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3NotEqualTo(String value) {
            addCriterion("backup3 <>", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3GreaterThan(String value) {
            addCriterion("backup3 >", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3GreaterThanOrEqualTo(String value) {
            addCriterion("backup3 >=", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3LessThan(String value) {
            addCriterion("backup3 <", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3LessThanOrEqualTo(String value) {
            addCriterion("backup3 <=", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3Like(String value) {
            addCriterion("backup3 like", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3NotLike(String value) {
            addCriterion("backup3 not like", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3In(List<String> values) {
            addCriterion("backup3 in", values, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3NotIn(List<String> values) {
            addCriterion("backup3 not in", values, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3Between(String value1, String value2) {
            addCriterion("backup3 between", value1, value2, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3NotBetween(String value1, String value2) {
            addCriterion("backup3 not between", value1, value2, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup4IsNull() {
            addCriterion("backup4 is null");
            return (Criteria) this;
        }

        public Criteria andBackup4IsNotNull() {
            addCriterion("backup4 is not null");
            return (Criteria) this;
        }

        public Criteria andBackup4EqualTo(String value) {
            addCriterion("backup4 =", value, "backup4");
            return (Criteria) this;
        }

        public Criteria andBackup4NotEqualTo(String value) {
            addCriterion("backup4 <>", value, "backup4");
            return (Criteria) this;
        }

        public Criteria andBackup4GreaterThan(String value) {
            addCriterion("backup4 >", value, "backup4");
            return (Criteria) this;
        }

        public Criteria andBackup4GreaterThanOrEqualTo(String value) {
            addCriterion("backup4 >=", value, "backup4");
            return (Criteria) this;
        }

        public Criteria andBackup4LessThan(String value) {
            addCriterion("backup4 <", value, "backup4");
            return (Criteria) this;
        }

        public Criteria andBackup4LessThanOrEqualTo(String value) {
            addCriterion("backup4 <=", value, "backup4");
            return (Criteria) this;
        }

        public Criteria andBackup4Like(String value) {
            addCriterion("backup4 like", value, "backup4");
            return (Criteria) this;
        }

        public Criteria andBackup4NotLike(String value) {
            addCriterion("backup4 not like", value, "backup4");
            return (Criteria) this;
        }

        public Criteria andBackup4In(List<String> values) {
            addCriterion("backup4 in", values, "backup4");
            return (Criteria) this;
        }

        public Criteria andBackup4NotIn(List<String> values) {
            addCriterion("backup4 not in", values, "backup4");
            return (Criteria) this;
        }

        public Criteria andBackup4Between(String value1, String value2) {
            addCriterion("backup4 between", value1, value2, "backup4");
            return (Criteria) this;
        }

        public Criteria andBackup4NotBetween(String value1, String value2) {
            addCriterion("backup4 not between", value1, value2, "backup4");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_vote_record
     *
     * @mbggenerated do_not_delete_during_merge Tue Jul 02 21:21:17 CST 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_vote_record
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
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