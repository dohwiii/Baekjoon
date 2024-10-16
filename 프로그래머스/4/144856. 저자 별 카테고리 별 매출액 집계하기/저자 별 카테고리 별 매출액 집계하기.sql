SELECT b.AUTHOR_ID, AUTHOR_NAME, CATEGORY, sum(total*price) as 'TOTAL_SALES'
from (select book_id, SALES_DATE, sum(sales) as total
      from BOOK_SALES
      WHERE DATE_FORMAT(SALES_DATE, '%Y-%m') = '2022-01'
      group by book_id
     ) s
     join BOOK b using (BOOK_ID)
     join AUTHOR a on b.AUTHOR_ID = a.AUTHOR_ID 
group by b.AUTHOR_ID, AUTHOR_NAME, CATEGORY
order by a.AUTHOR_ID, CATEGORY desc;