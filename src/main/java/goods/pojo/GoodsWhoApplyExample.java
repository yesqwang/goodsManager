package goods.pojo;

import java.util.ArrayList;
import java.util.List;

public class GoodsWhoApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    //用于分页
    protected int offset;
    protected int limit;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
    public GoodsWhoApplyExample() {
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

        public Criteria andGoodsApplyIdIsNull() {
            addCriterion("goods_apply_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyIdIsNotNull() {
            addCriterion("goods_apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyIdEqualTo(Integer value) {
            addCriterion("goods_apply_id =", value, "goodsApplyId");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyIdNotEqualTo(Integer value) {
            addCriterion("goods_apply_id <>", value, "goodsApplyId");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyIdGreaterThan(Integer value) {
            addCriterion("goods_apply_id >", value, "goodsApplyId");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_apply_id >=", value, "goodsApplyId");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyIdLessThan(Integer value) {
            addCriterion("goods_apply_id <", value, "goodsApplyId");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_apply_id <=", value, "goodsApplyId");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyIdIn(List<Integer> values) {
            addCriterion("goods_apply_id in", values, "goodsApplyId");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyIdNotIn(List<Integer> values) {
            addCriterion("goods_apply_id not in", values, "goodsApplyId");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_apply_id between", value1, value2, "goodsApplyId");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_apply_id not between", value1, value2, "goodsApplyId");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyerIsNull() {
            addCriterion("goods_applyer is null");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyerIsNotNull() {
            addCriterion("goods_applyer is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyerEqualTo(String value) {
            addCriterion("goods_applyer =", value, "goodsApplyer");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyerNotEqualTo(String value) {
            addCriterion("goods_applyer <>", value, "goodsApplyer");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyerGreaterThan(String value) {
            addCriterion("goods_applyer >", value, "goodsApplyer");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyerGreaterThanOrEqualTo(String value) {
            addCriterion("goods_applyer >=", value, "goodsApplyer");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyerLessThan(String value) {
            addCriterion("goods_applyer <", value, "goodsApplyer");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyerLessThanOrEqualTo(String value) {
            addCriterion("goods_applyer <=", value, "goodsApplyer");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyerLike(String value) {
            addCriterion("goods_applyer like", value, "goodsApplyer");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyerNotLike(String value) {
            addCriterion("goods_applyer not like", value, "goodsApplyer");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyerIn(List<String> values) {
            addCriterion("goods_applyer in", values, "goodsApplyer");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyerNotIn(List<String> values) {
            addCriterion("goods_applyer not in", values, "goodsApplyer");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyerBetween(String value1, String value2) {
            addCriterion("goods_applyer between", value1, value2, "goodsApplyer");
            return (Criteria) this;
        }

        public Criteria andGoodsApplyerNotBetween(String value1, String value2) {
            addCriterion("goods_applyer not between", value1, value2, "goodsApplyer");
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