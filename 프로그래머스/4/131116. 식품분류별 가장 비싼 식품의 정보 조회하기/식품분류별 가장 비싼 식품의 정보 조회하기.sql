# select * from food_product;

SELECT CATEGORY, price as 'MAX_PRICE', PRODUCT_NAME
from FOOD_PRODUCT 
where (category, price) in (select category, max(price)
      from FOOD_PRODUCT
      where CATEGORY IN ('과자', '국', '김치', '식용유')
      group by category
     ) 
order by PRICE desc;

# select category, max(price)
#       from FOOD_PRODUCT
#       where CATEGORY IN ('과자', '국', '김치', '식용유')
#       group by category;