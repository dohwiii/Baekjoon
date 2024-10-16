-- 코드를 입력하세요
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
from REST_INFO a
where a.FAVORITES = (
    select max(FAVORITES) 
    from REST_INFO b
    where a.FOOD_TYPE = b.FOOD_TYPE
) 
order by FOOD_TYPE desc;