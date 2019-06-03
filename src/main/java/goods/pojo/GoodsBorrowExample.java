package goods.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsBorrowExample {
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
    public GoodsBorrowExample() {
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

        public Criteria andGbidIsNull() {
            addCriterion("gbid is null");
            return (Criteria) this;
        }

        public Criteria andGbidIsNotNull() {
            addCriterion("gbid is not null");
            return (Criteria) this;
        }

        public Criteria andGbidEqualTo(Integer value) {
            addCriterion("gbid =", value, "gbid");
            return (Criteria) this;
        }

        public Criteria andGbidNotEqualTo(Integer value) {
            addCriterion("gbid <>", value, "gbid");
            return (Criteria) this;
        }

        public Criteria andGbidGreaterThan(Integer value) {
            addCriterion("gbid >", value, "gbid");
            return (Criteria) this;
        }

        public Criteria andGbidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gbid >=", value, "gbid");
            return (Criteria) this;
        }

        public Criteria andGbidLessThan(Integer value) {
            addCriterion("gbid <", value, "gbid");
            return (Criteria) this;
        }

        public Criteria andGbidLessThanOrEqualTo(Integer value) {
            addCriterion("gbid <=", value, "gbid");
            return (Criteria) this;
        }

        public Criteria andGbidIn(List<Integer> values) {
            addCriterion("gbid in", values, "gbid");
            return (Criteria) this;
        }

        public Criteria andGbidNotIn(List<Integer> values) {
            addCriterion("gbid not in", values, "gbid");
            return (Criteria) this;
        }

        public Criteria andGbidBetween(Integer value1, Integer value2) {
            addCriterion("gbid between", value1, value2, "gbid");
            return (Criteria) this;
        }

        public Criteria andGbidNotBetween(Integer value1, Integer value2) {
            addCriterion("gbid not between", value1, value2, "gbid");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
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

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andBorrowDateIsNull() {
            addCriterion("borrow_date is null");
            return (Criteria) this;
        }

        public Criteria andBorrowDateIsNotNull() {
            addCriterion("borrow_date is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowDateEqualTo(Date value) {
            addCriterion("borrow_date =", value, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateNotEqualTo(Date value) {
            addCriterion("borrow_date <>", value, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateGreaterThan(Date value) {
            addCriterion("borrow_date >", value, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateGreaterThanOrEqualTo(Date value) {
            addCriterion("borrow_date >=", value, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateLessThan(Date value) {
            addCriterion("borrow_date <", value, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateLessThanOrEqualTo(Date value) {
            addCriterion("borrow_date <=", value, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateIn(List<Date> values) {
            addCriterion("borrow_date in", values, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateNotIn(List<Date> values) {
            addCriterion("borrow_date not in", values, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateBetween(Date value1, Date value2) {
            addCriterion("borrow_date between", value1, value2, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateNotBetween(Date value1, Date value2) {
            addCriterion("borrow_date not between", value1, value2, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIsBorrowIsNull() {
            addCriterion("is_borrow is null");
            return (Criteria) this;
        }

        public Criteria andIsBorrowIsNotNull() {
            addCriterion("is_borrow is not null");
            return (Criteria) this;
        }

        public Criteria andIsBorrowEqualTo(Boolean value) {
            addCriterion("is_borrow =", value, "isBorrow");
            return (Criteria) this;
        }

        public Criteria andIsBorrowNotEqualTo(Boolean value) {
            addCriterion("is_borrow <>", value, "isBorrow");
            return (Criteria) this;
        }

        public Criteria andIsBorrowGreaterThan(Boolean value) {
            addCriterion("is_borrow >", value, "isBorrow");
            return (Criteria) this;
        }

        public Criteria andIsBorrowGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_borrow >=", value, "isBorrow");
            return (Criteria) this;
        }

        public Criteria andIsBorrowLessThan(Boolean value) {
            addCriterion("is_borrow <", value, "isBorrow");
            return (Criteria) this;
        }

        public Criteria andIsBorrowLessThanOrEqualTo(Boolean value) {
            addCriterion("is_borrow <=", value, "isBorrow");
            return (Criteria) this;
        }

        public Criteria andIsBorrowIn(List<Boolean> values) {
            addCriterion("is_borrow in", values, "isBorrow");
            return (Criteria) this;
        }

        public Criteria andIsBorrowNotIn(List<Boolean> values) {
            addCriterion("is_borrow not in", values, "isBorrow");
            return (Criteria) this;
        }

        public Criteria andIsBorrowBetween(Boolean value1, Boolean value2) {
            addCriterion("is_borrow between", value1, value2, "isBorrow");
            return (Criteria) this;
        }

        public Criteria andIsBorrowNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_borrow not between", value1, value2, "isBorrow");
            return (Criteria) this;
        }

        public Criteria andWillReturnDateIsNull() {
            addCriterion("will_return_date is null");
            return (Criteria) this;
        }

        public Criteria andWillReturnDateIsNotNull() {
            addCriterion("will_return_date is not null");
            return (Criteria) this;
        }

        public Criteria andWillReturnDateEqualTo(Date value) {
            addCriterion("will_return_date =", value, "willReturnDate");
            return (Criteria) this;
        }

        public Criteria andWillReturnDateNotEqualTo(Date value) {
            addCriterion("will_return_date <>", value, "willReturnDate");
            return (Criteria) this;
        }

        public Criteria andWillReturnDateGreaterThan(Date value) {
            addCriterion("will_return_date >", value, "willReturnDate");
            return (Criteria) this;
        }

        public Criteria andWillReturnDateGreaterThanOrEqualTo(Date value) {
            addCriterion("will_return_date >=", value, "willReturnDate");
            return (Criteria) this;
        }

        public Criteria andWillReturnDateLessThan(Date value) {
            addCriterion("will_return_date <", value, "willReturnDate");
            return (Criteria) this;
        }

        public Criteria andWillReturnDateLessThanOrEqualTo(Date value) {
            addCriterion("will_return_date <=", value, "willReturnDate");
            return (Criteria) this;
        }

        public Criteria andWillReturnDateIn(List<Date> values) {
            addCriterion("will_return_date in", values, "willReturnDate");
            return (Criteria) this;
        }

        public Criteria andWillReturnDateNotIn(List<Date> values) {
            addCriterion("will_return_date not in", values, "willReturnDate");
            return (Criteria) this;
        }

        public Criteria andWillReturnDateBetween(Date value1, Date value2) {
            addCriterion("will_return_date between", value1, value2, "willReturnDate");
            return (Criteria) this;
        }

        public Criteria andWillReturnDateNotBetween(Date value1, Date value2) {
            addCriterion("will_return_date not between", value1, value2, "willReturnDate");
            return (Criteria) this;
        }

        public Criteria andBorrowUserIdIsNull() {
            addCriterion("borrow_user_id is null");
            return (Criteria) this;
        }

        public Criteria andBorrowUserIdIsNotNull() {
            addCriterion("borrow_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowUserIdEqualTo(String value) {
            addCriterion("borrow_user_id =", value, "borrowUserId");
            return (Criteria) this;
        }

        public Criteria andBorrowUserIdNotEqualTo(String value) {
            addCriterion("borrow_user_id <>", value, "borrowUserId");
            return (Criteria) this;
        }

        public Criteria andBorrowUserIdGreaterThan(String value) {
            addCriterion("borrow_user_id >", value, "borrowUserId");
            return (Criteria) this;
        }

        public Criteria andBorrowUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_user_id >=", value, "borrowUserId");
            return (Criteria) this;
        }

        public Criteria andBorrowUserIdLessThan(String value) {
            addCriterion("borrow_user_id <", value, "borrowUserId");
            return (Criteria) this;
        }

        public Criteria andBorrowUserIdLessThanOrEqualTo(String value) {
            addCriterion("borrow_user_id <=", value, "borrowUserId");
            return (Criteria) this;
        }

        public Criteria andBorrowUserIdLike(String value) {
            addCriterion("borrow_user_id like", value, "borrowUserId");
            return (Criteria) this;
        }

        public Criteria andBorrowUserIdNotLike(String value) {
            addCriterion("borrow_user_id not like", value, "borrowUserId");
            return (Criteria) this;
        }

        public Criteria andBorrowUserIdIn(List<String> values) {
            addCriterion("borrow_user_id in", values, "borrowUserId");
            return (Criteria) this;
        }

        public Criteria andBorrowUserIdNotIn(List<String> values) {
            addCriterion("borrow_user_id not in", values, "borrowUserId");
            return (Criteria) this;
        }

        public Criteria andBorrowUserIdBetween(String value1, String value2) {
            addCriterion("borrow_user_id between", value1, value2, "borrowUserId");
            return (Criteria) this;
        }

        public Criteria andBorrowUserIdNotBetween(String value1, String value2) {
            addCriterion("borrow_user_id not between", value1, value2, "borrowUserId");
            return (Criteria) this;
        }

        public Criteria andReturnUserIdIsNull() {
            addCriterion("return_user_id is null");
            return (Criteria) this;
        }

        public Criteria andReturnUserIdIsNotNull() {
            addCriterion("return_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andReturnUserIdEqualTo(String value) {
            addCriterion("return_user_id =", value, "returnUserId");
            return (Criteria) this;
        }

        public Criteria andReturnUserIdNotEqualTo(String value) {
            addCriterion("return_user_id <>", value, "returnUserId");
            return (Criteria) this;
        }

        public Criteria andReturnUserIdGreaterThan(String value) {
            addCriterion("return_user_id >", value, "returnUserId");
            return (Criteria) this;
        }

        public Criteria andReturnUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("return_user_id >=", value, "returnUserId");
            return (Criteria) this;
        }

        public Criteria andReturnUserIdLessThan(String value) {
            addCriterion("return_user_id <", value, "returnUserId");
            return (Criteria) this;
        }

        public Criteria andReturnUserIdLessThanOrEqualTo(String value) {
            addCriterion("return_user_id <=", value, "returnUserId");
            return (Criteria) this;
        }

        public Criteria andReturnUserIdLike(String value) {
            addCriterion("return_user_id like", value, "returnUserId");
            return (Criteria) this;
        }

        public Criteria andReturnUserIdNotLike(String value) {
            addCriterion("return_user_id not like", value, "returnUserId");
            return (Criteria) this;
        }

        public Criteria andReturnUserIdIn(List<String> values) {
            addCriterion("return_user_id in", values, "returnUserId");
            return (Criteria) this;
        }

        public Criteria andReturnUserIdNotIn(List<String> values) {
            addCriterion("return_user_id not in", values, "returnUserId");
            return (Criteria) this;
        }

        public Criteria andReturnUserIdBetween(String value1, String value2) {
            addCriterion("return_user_id between", value1, value2, "returnUserId");
            return (Criteria) this;
        }

        public Criteria andReturnUserIdNotBetween(String value1, String value2) {
            addCriterion("return_user_id not between", value1, value2, "returnUserId");
            return (Criteria) this;
        }

        public Criteria andReturnNumberIsNull() {
            addCriterion("return_number is null");
            return (Criteria) this;
        }

        public Criteria andReturnNumberIsNotNull() {
            addCriterion("return_number is not null");
            return (Criteria) this;
        }

        public Criteria andReturnNumberEqualTo(Integer value) {
            addCriterion("return_number =", value, "returnNumber");
            return (Criteria) this;
        }

        public Criteria andReturnNumberNotEqualTo(Integer value) {
            addCriterion("return_number <>", value, "returnNumber");
            return (Criteria) this;
        }

        public Criteria andReturnNumberGreaterThan(Integer value) {
            addCriterion("return_number >", value, "returnNumber");
            return (Criteria) this;
        }

        public Criteria andReturnNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_number >=", value, "returnNumber");
            return (Criteria) this;
        }

        public Criteria andReturnNumberLessThan(Integer value) {
            addCriterion("return_number <", value, "returnNumber");
            return (Criteria) this;
        }

        public Criteria andReturnNumberLessThanOrEqualTo(Integer value) {
            addCriterion("return_number <=", value, "returnNumber");
            return (Criteria) this;
        }

        public Criteria andReturnNumberIn(List<Integer> values) {
            addCriterion("return_number in", values, "returnNumber");
            return (Criteria) this;
        }

        public Criteria andReturnNumberNotIn(List<Integer> values) {
            addCriterion("return_number not in", values, "returnNumber");
            return (Criteria) this;
        }

        public Criteria andReturnNumberBetween(Integer value1, Integer value2) {
            addCriterion("return_number between", value1, value2, "returnNumber");
            return (Criteria) this;
        }

        public Criteria andReturnNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("return_number not between", value1, value2, "returnNumber");
            return (Criteria) this;
        }

        public Criteria andReturnDateIsNull() {
            addCriterion("return_date is null");
            return (Criteria) this;
        }

        public Criteria andReturnDateIsNotNull() {
            addCriterion("return_date is not null");
            return (Criteria) this;
        }

        public Criteria andReturnDateEqualTo(Date value) {
            addCriterion("return_date =", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotEqualTo(Date value) {
            addCriterion("return_date <>", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateGreaterThan(Date value) {
            addCriterion("return_date >", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateGreaterThanOrEqualTo(Date value) {
            addCriterion("return_date >=", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateLessThan(Date value) {
            addCriterion("return_date <", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateLessThanOrEqualTo(Date value) {
            addCriterion("return_date <=", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateIn(List<Date> values) {
            addCriterion("return_date in", values, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotIn(List<Date> values) {
            addCriterion("return_date not in", values, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateBetween(Date value1, Date value2) {
            addCriterion("return_date between", value1, value2, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotBetween(Date value1, Date value2) {
            addCriterion("return_date not between", value1, value2, "returnDate");
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