-- 코드를 입력하세요
WITH TABLE1 AS (
    SELECT A.MEMBER_ID AS MEMBER_ID, COUNT(*) AS COUNT
    FROM MEMBER_PROFILE A JOIN REST_REVIEW B ON A.MEMBER_ID = B.MEMBER_ID
    GROUP BY A.MEMBER_ID
    ORDER BY COUNT DESC
    LIMIT 1
)

SELECT MEMBER_NAME, REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE, "%Y-%m-%d") AS REVIEW_DATE
FROM REST_REVIEW A JOIN MEMBER_PROFILE B ON A.MEMBER_ID = B.MEMBER_ID
WHERE A.MEMBER_ID IN (SELECT MEMBER_ID FROM TABLE1)
ORDER BY REVIEW_DATE, REVIEW_TEXT