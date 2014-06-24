package net.zillions.buffett.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbMemoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.tb_memo
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.tb_memo
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.tb_memo
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_memo
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    public TbMemoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_memo
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_memo
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_memo
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_memo
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_memo
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_memo
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_memo
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_memo
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
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
     * This method corresponds to the database table public.tb_memo
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_memo
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.tb_memo
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
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

        public Criteria andMemoIdIsNull() {
            addCriterion("memo_id is null");
            return (Criteria) this;
        }

        public Criteria andMemoIdIsNotNull() {
            addCriterion("memo_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemoIdEqualTo(Integer value) {
            addCriterion("memo_id =", value, "memoId");
            return (Criteria) this;
        }

        public Criteria andMemoIdNotEqualTo(Integer value) {
            addCriterion("memo_id <>", value, "memoId");
            return (Criteria) this;
        }

        public Criteria andMemoIdGreaterThan(Integer value) {
            addCriterion("memo_id >", value, "memoId");
            return (Criteria) this;
        }

        public Criteria andMemoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("memo_id >=", value, "memoId");
            return (Criteria) this;
        }

        public Criteria andMemoIdLessThan(Integer value) {
            addCriterion("memo_id <", value, "memoId");
            return (Criteria) this;
        }

        public Criteria andMemoIdLessThanOrEqualTo(Integer value) {
            addCriterion("memo_id <=", value, "memoId");
            return (Criteria) this;
        }

        public Criteria andMemoIdIn(List<Integer> values) {
            addCriterion("memo_id in", values, "memoId");
            return (Criteria) this;
        }

        public Criteria andMemoIdNotIn(List<Integer> values) {
            addCriterion("memo_id not in", values, "memoId");
            return (Criteria) this;
        }

        public Criteria andMemoIdBetween(Integer value1, Integer value2) {
            addCriterion("memo_id between", value1, value2, "memoId");
            return (Criteria) this;
        }

        public Criteria andMemoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("memo_id not between", value1, value2, "memoId");
            return (Criteria) this;
        }

        public Criteria andMemoContentIsNull() {
            addCriterion("memo_content is null");
            return (Criteria) this;
        }

        public Criteria andMemoContentIsNotNull() {
            addCriterion("memo_content is not null");
            return (Criteria) this;
        }

        public Criteria andMemoContentEqualTo(String value) {
            addCriterion("memo_content =", value, "memoContent");
            return (Criteria) this;
        }

        public Criteria andMemoContentNotEqualTo(String value) {
            addCriterion("memo_content <>", value, "memoContent");
            return (Criteria) this;
        }

        public Criteria andMemoContentGreaterThan(String value) {
            addCriterion("memo_content >", value, "memoContent");
            return (Criteria) this;
        }

        public Criteria andMemoContentGreaterThanOrEqualTo(String value) {
            addCriterion("memo_content >=", value, "memoContent");
            return (Criteria) this;
        }

        public Criteria andMemoContentLessThan(String value) {
            addCriterion("memo_content <", value, "memoContent");
            return (Criteria) this;
        }

        public Criteria andMemoContentLessThanOrEqualTo(String value) {
            addCriterion("memo_content <=", value, "memoContent");
            return (Criteria) this;
        }

        public Criteria andMemoContentLike(String value) {
            addCriterion("memo_content like", value, "memoContent");
            return (Criteria) this;
        }

        public Criteria andMemoContentNotLike(String value) {
            addCriterion("memo_content not like", value, "memoContent");
            return (Criteria) this;
        }

        public Criteria andMemoContentIn(List<String> values) {
            addCriterion("memo_content in", values, "memoContent");
            return (Criteria) this;
        }

        public Criteria andMemoContentNotIn(List<String> values) {
            addCriterion("memo_content not in", values, "memoContent");
            return (Criteria) this;
        }

        public Criteria andMemoContentBetween(String value1, String value2) {
            addCriterion("memo_content between", value1, value2, "memoContent");
            return (Criteria) this;
        }

        public Criteria andMemoContentNotBetween(String value1, String value2) {
            addCriterion("memo_content not between", value1, value2, "memoContent");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Boolean value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Boolean value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Boolean value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Boolean value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Boolean> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Boolean> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.tb_memo
     *
     * @mbggenerated do_not_delete_during_merge Mon Jun 23 23:35:12 JST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.tb_memo
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
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