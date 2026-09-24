-- 코드를 입력하세요
-- 식품가격 내림차순
-- 과자, 국, 김치, 식용유만 출력
-- 카테고리별 가장 비싼 식품 1개만 출력
-- SELECT * FROM FOOD_PRODUCT
-- P0093	맛있는허니버터칩	CD_CK00003	과자	1950
-- P0074	맛있는김치찌개	CD_SU00004	국	2900
-- P0051	맛있는배추김치	CD_KC00001	김치	19000
-- P0014	맛있는마조유	CD_OL00004	식용유	8950

select f.CATEGORY, max_price, PRODUCT_NAME
from FOOD_PRODUCT f inner join 
(SELECT CATEGORY, max(price) as MAX_PRICE
FROM FOOD_PRODUCT
group by CATEGORY
having CATEGORY in ('과자', '국', '김치', '식용유')
) d on f.category = d.category
where price = max_price
order by MAX_PRICE desc;