package goods.pojo;

import java.util.ArrayList;
import java.util.List;

public class GoodsStoreExample {
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
    public GoodsStoreExample() {
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

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsKindIsNull() {
            addCriterion("goods_kind is null");
            return (Criteria) this;
        }

        public Criteria andGoodsKindIsNotNull() {
            addCriterion("goods_kind is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsKindEqualTo(Integer value) {
            addCriterion("goods_kind =", value, "goodsKind");
            return (Criteria) this;
        }

        public Criteria andGoodsKindNotEqualTo(Integer value) {
            addCriterion("goods_kind <>", value, "goodsKind");
            return (Criteria) this;
        }

        public Criteria andGoodsKindGreaterThan(Integer value) {
            addCriterion("goods_kind >", value, "goodsKind");
            return (Criteria) this;
        }

        public Criteria andGoodsKindGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_kind >=", value, "goodsKind");
            return (Criteria) this;
        }

        public Criteria andGoodsKindLessThan(Integer value) {
            addCriterion("goods_kind <", value, "goodsKind");
            return (Criteria) this;
        }

        public Criteria andGoodsKindLessThanOrEqualTo(Integer value) {
            addCriterion("goods_kind <=", value, "goodsKind");
            return (Criteria) this;
        }

        public Criteria andGoodsKindIn(List<Integer> values) {
            addCriterion("goods_kind in", values, "goodsKind");
            return (Criteria) this;
        }

        public Criteria andGoodsKindNotIn(List<Integer> values) {
            addCriterion("goods_kind not in", values, "goodsKind");
            return (Criteria) this;
        }

        public Criteria andGoodsKindBetween(Integer value1, Integer value2) {
            addCriterion("goods_kind between", value1, value2, "goodsKind");
            return (Criteria) this;
        }

        public Criteria andGoodsKindNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_kind not between", value1, value2, "goodsKind");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandIsNull() {
            addCriterion("goods_brand is null");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandIsNotNull() {
            addCriterion("goods_brand is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandEqualTo(Integer value) {
            addCriterion("goods_brand =", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandNotEqualTo(Integer value) {
            addCriterion("goods_brand <>", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandGreaterThan(Integer value) {
            addCriterion("goods_brand >", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_brand >=", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandLessThan(Integer value) {
            addCriterion("goods_brand <", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandLessThanOrEqualTo(Integer value) {
            addCriterion("goods_brand <=", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandIn(List<Integer> values) {
            addCriterion("goods_brand in", values, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandNotIn(List<Integer> values) {
            addCriterion("goods_brand not in", values, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandBetween(Integer value1, Integer value2) {
            addCriterion("goods_brand between", value1, value2, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_brand not between", value1, value2, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsModelIsNull() {
            addCriterion("goods_model is null");
            return (Criteria) this;
        }

        public Criteria andGoodsModelIsNotNull() {
            addCriterion("goods_model is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsModelEqualTo(String value) {
            addCriterion("goods_model =", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelNotEqualTo(String value) {
            addCriterion("goods_model <>", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelGreaterThan(String value) {
            addCriterion("goods_model >", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelGreaterThanOrEqualTo(String value) {
            addCriterion("goods_model >=", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelLessThan(String value) {
            addCriterion("goods_model <", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelLessThanOrEqualTo(String value) {
            addCriterion("goods_model <=", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelLike(String value) {
            addCriterion("goods_model like", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelNotLike(String value) {
            addCriterion("goods_model not like", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelIn(List<String> values) {
            addCriterion("goods_model in", values, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelNotIn(List<String> values) {
            addCriterion("goods_model not in", values, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelBetween(String value1, String value2) {
            addCriterion("goods_model between", value1, value2, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelNotBetween(String value1, String value2) {
            addCriterion("goods_model not between", value1, value2, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsParmIsNull() {
            addCriterion("goods_parm is null");
            return (Criteria) this;
        }

        public Criteria andGoodsParmIsNotNull() {
            addCriterion("goods_parm is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsParmEqualTo(String value) {
            addCriterion("goods_parm =", value, "goodsParm");
            return (Criteria) this;
        }

        public Criteria andGoodsParmNotEqualTo(String value) {
            addCriterion("goods_parm <>", value, "goodsParm");
            return (Criteria) this;
        }

        public Criteria andGoodsParmGreaterThan(String value) {
            addCriterion("goods_parm >", value, "goodsParm");
            return (Criteria) this;
        }

        public Criteria andGoodsParmGreaterThanOrEqualTo(String value) {
            addCriterion("goods_parm >=", value, "goodsParm");
            return (Criteria) this;
        }

        public Criteria andGoodsParmLessThan(String value) {
            addCriterion("goods_parm <", value, "goodsParm");
            return (Criteria) this;
        }

        public Criteria andGoodsParmLessThanOrEqualTo(String value) {
            addCriterion("goods_parm <=", value, "goodsParm");
            return (Criteria) this;
        }

        public Criteria andGoodsParmLike(String value) {
            addCriterion("goods_parm like", value, "goodsParm");
            return (Criteria) this;
        }

        public Criteria andGoodsParmNotLike(String value) {
            addCriterion("goods_parm not like", value, "goodsParm");
            return (Criteria) this;
        }

        public Criteria andGoodsParmIn(List<String> values) {
            addCriterion("goods_parm in", values, "goodsParm");
            return (Criteria) this;
        }

        public Criteria andGoodsParmNotIn(List<String> values) {
            addCriterion("goods_parm not in", values, "goodsParm");
            return (Criteria) this;
        }

        public Criteria andGoodsParmBetween(String value1, String value2) {
            addCriterion("goods_parm between", value1, value2, "goodsParm");
            return (Criteria) this;
        }

        public Criteria andGoodsParmNotBetween(String value1, String value2) {
            addCriterion("goods_parm not between", value1, value2, "goodsParm");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitIsNull() {
            addCriterion("goods_unit is null");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitIsNotNull() {
            addCriterion("goods_unit is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitEqualTo(Integer value) {
            addCriterion("goods_unit =", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitNotEqualTo(Integer value) {
            addCriterion("goods_unit <>", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitGreaterThan(Integer value) {
            addCriterion("goods_unit >", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_unit >=", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitLessThan(Integer value) {
            addCriterion("goods_unit <", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitLessThanOrEqualTo(Integer value) {
            addCriterion("goods_unit <=", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitIn(List<Integer> values) {
            addCriterion("goods_unit in", values, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitNotIn(List<Integer> values) {
            addCriterion("goods_unit not in", values, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitBetween(Integer value1, Integer value2) {
            addCriterion("goods_unit between", value1, value2, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_unit not between", value1, value2, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIsNull() {
            addCriterion("goods_number is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIsNotNull() {
            addCriterion("goods_number is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberEqualTo(Integer value) {
            addCriterion("goods_number =", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotEqualTo(Integer value) {
            addCriterion("goods_number <>", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberGreaterThan(Integer value) {
            addCriterion("goods_number >", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_number >=", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberLessThan(Integer value) {
            addCriterion("goods_number <", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberLessThanOrEqualTo(Integer value) {
            addCriterion("goods_number <=", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIn(List<Integer> values) {
            addCriterion("goods_number in", values, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotIn(List<Integer> values) {
            addCriterion("goods_number not in", values, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberBetween(Integer value1, Integer value2) {
            addCriterion("goods_number between", value1, value2, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_number not between", value1, value2, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsGiveNumberIsNull() {
            addCriterion("goods_give_number is null");
            return (Criteria) this;
        }

        public Criteria andGoodsGiveNumberIsNotNull() {
            addCriterion("goods_give_number is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsGiveNumberEqualTo(Integer value) {
            addCriterion("goods_give_number =", value, "goodsGiveNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsGiveNumberNotEqualTo(Integer value) {
            addCriterion("goods_give_number <>", value, "goodsGiveNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsGiveNumberGreaterThan(Integer value) {
            addCriterion("goods_give_number >", value, "goodsGiveNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsGiveNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_give_number >=", value, "goodsGiveNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsGiveNumberLessThan(Integer value) {
            addCriterion("goods_give_number <", value, "goodsGiveNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsGiveNumberLessThanOrEqualTo(Integer value) {
            addCriterion("goods_give_number <=", value, "goodsGiveNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsGiveNumberIn(List<Integer> values) {
            addCriterion("goods_give_number in", values, "goodsGiveNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsGiveNumberNotIn(List<Integer> values) {
            addCriterion("goods_give_number not in", values, "goodsGiveNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsGiveNumberBetween(Integer value1, Integer value2) {
            addCriterion("goods_give_number between", value1, value2, "goodsGiveNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsGiveNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_give_number not between", value1, value2, "goodsGiveNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsBorrowNumberIsNull() {
            addCriterion("goods_borrow_number is null");
            return (Criteria) this;
        }

        public Criteria andGoodsBorrowNumberIsNotNull() {
            addCriterion("goods_borrow_number is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsBorrowNumberEqualTo(Integer value) {
            addCriterion("goods_borrow_number =", value, "goodsBorrowNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsBorrowNumberNotEqualTo(Integer value) {
            addCriterion("goods_borrow_number <>", value, "goodsBorrowNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsBorrowNumberGreaterThan(Integer value) {
            addCriterion("goods_borrow_number >", value, "goodsBorrowNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsBorrowNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_borrow_number >=", value, "goodsBorrowNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsBorrowNumberLessThan(Integer value) {
            addCriterion("goods_borrow_number <", value, "goodsBorrowNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsBorrowNumberLessThanOrEqualTo(Integer value) {
            addCriterion("goods_borrow_number <=", value, "goodsBorrowNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsBorrowNumberIn(List<Integer> values) {
            addCriterion("goods_borrow_number in", values, "goodsBorrowNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsBorrowNumberNotIn(List<Integer> values) {
            addCriterion("goods_borrow_number not in", values, "goodsBorrowNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsBorrowNumberBetween(Integer value1, Integer value2) {
            addCriterion("goods_borrow_number between", value1, value2, "goodsBorrowNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsBorrowNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_borrow_number not between", value1, value2, "goodsBorrowNumber");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
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