-- 코드를 입력하세요

SET @BASE = '/home/grep/src/';
SET @ID = (
    SELECT BOARD_ID 
    FROM USED_GOODS_BOARD 
    ORDER BY VIEWS DESC 
    LIMIT 1);

SELECT CONCAT(@BASE, @ID, '/', FILE_ID, FILE_NAME, FILE_EXT) AS FILE_PATH
FROM USED_GOODS_FILE
WHERE BOARD_ID = @ID
ORDER BY FILE_ID DESC