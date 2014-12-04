SELECT 
	cod_lancamento AS "Código", 
	val_numdocumento AS "Número do documento", 
	dat_lancamento AS "Data do lançamento", 
	val_lancamento AS "Valor", 
	val_vinculado AS "Valor vinculado", 
	des_origem AS "Origem", 
	des_conta "Conta", 
	des_classificacao AS "Classificação" 
FROM 
	lancamento
INNER JOIN conta ON conta.id_conta = lancamento.fk_conta
INNER JOIN classificacao ON classificacao.id_classificacao = lancamento.fk_classificacao