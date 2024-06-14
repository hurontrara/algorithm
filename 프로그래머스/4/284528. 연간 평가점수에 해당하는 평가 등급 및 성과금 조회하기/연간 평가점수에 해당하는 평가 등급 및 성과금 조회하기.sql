-- 코드를 작성해주세요

SELECT A.EMP_NO, A.EMP_NAME, B.GRADE, 
CASE
WHEN B.GRADE = 'S' THEN A.SAL * .2
WHEN B.GRADE = 'A' THEN A.SAL * .15
WHEN B.GRADE = 'B' THEN A.SAL * .1
ELSE 0
END AS BONUS
FROM HR_EMPLOYEES A JOIN (SELECT A.EMP_NO,
                            CASE 
                            WHEN (MEAN_SCORE >= 96) THEN 'S'
                            WHEN (MEAN_SCORE >= 90) THEN 'A'
                            WHEN (MEAN_SCORE >= 80) THEN 'B'
                            ELSE 'C'
                            END AS GRADE
                            FROM (
                                SELECT EMP_NO, AVG(SCORE) AS MEAN_SCORE
                                FROM HR_GRADE
                                GROUP BY EMP_NO
                            ) A) B ON A.EMP_NO = B.EMP_NO
ORDER BY EMP_NO



