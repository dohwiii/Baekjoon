-- 코드를 입력하세요
SELECT concat('/home/grep/src/', board_id, '/', f.file_id, f.file_name, f.file_ext) as 'FILE_PATH'
from USED_GOODS_BOARD b join USED_GOODS_FILE f
using (board_id)
where b.views = (select views from USED_GOODS_BOARD group by board_id order by views desc limit 1)
order by file_id desc;
