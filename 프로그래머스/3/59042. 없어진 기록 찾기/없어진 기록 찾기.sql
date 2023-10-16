-- 코드를 입력하세요
SELECT o.animal_id, o.name
FROM ANIMAL_OUTS o left join ANIMAL_INS i
on i.animal_id = o.animal_id
where i.animal_id is null;