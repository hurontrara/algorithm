-- 코드를 작성해주세요

SELECT A.ID, A.GENOTYPE, B.GENOTYPE AS PARENT_GENOTYPE
FROM ECOLI_DATA A JOIN ECOLI_DATA B ON A.PARENT_ID = B.ID # B가 부모
WHERE A.GENOTYPE & B.GENOTYPE = B.GENOTYPE
ORDER BY ID