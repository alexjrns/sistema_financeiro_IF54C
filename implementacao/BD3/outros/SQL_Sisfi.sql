
CREATE TABLE public.conta (
                id_conta SERIAL NOT NULL,
                des_conta VARCHAR NOT NULL,
                val_saldo DOUBLE PRECISION NOT NULL,
                val_limitecredito DOUBLE PRECISION NOT NULL,
                dat_registro DATE NOT NULL,
                CONSTRAINT id_conta PRIMARY KEY (id_conta)
);


CREATE TABLE public.endereco (
                id_endereco SERIAL NOT NULL,
                cod_endereco INTEGER NOT NULL,
                des_logradouro VARCHAR NOT NULL,
                des_numero VARCHAR NOT NULL,
                val_cep VARCHAR NOT NULL,
                des_bairro VARCHAR NOT NULL,
                des_cidade VARCHAR NOT NULL,
                des_estado VARCHAR NOT NULL,
                CONSTRAINT id_endereco PRIMARY KEY (id_endereco)
);


CREATE TABLE public.pessoa (
                id_pessoa SERIAL NOT NULL,
                cod_pessoa INTEGER NOT NULL,
                des_razaosocial VARCHAR NOT NULL,
                val_cnpj VARCHAR NOT NULL,
                fk_endereco INTEGER NOT NULL,
                CONSTRAINT id_pessoa PRIMARY KEY (id_pessoa)
);


CREATE TABLE public.cliente (
                id_cliente SERIAL NOT NULL,
                fk_pessoa INTEGER NOT NULL,
                cod_cliente INTEGER NOT NULL,
                CONSTRAINT id_cliente PRIMARY KEY (id_cliente)
);


CREATE TABLE public.fornecedor (
                id_fornecedor SERIAL NOT NULL,
                cod_fornecedor INTEGER NOT NULL,
                fk_pessoa INTEGER NOT NULL,
                CONSTRAINT id_fornecedor PRIMARY KEY (id_fornecedor)
);


CREATE TABLE public.classificacao (
                id_classificacao SERIAL NOT NULL,
                cod_classificacao INTEGER NOT NULL,
                des_classificacao VARCHAR NOT NULL,
                des_tipooperacao VARCHAR NOT NULL,
                CONSTRAINT id_classificacao PRIMARY KEY (id_classificacao)
);


CREATE TABLE public.lancamento (
                id_lancamento SERIAL NOT NULL,
                val_numdocumento VARCHAR NOT NULL,
                dat_lancamento DATE NOT NULL,
                val_lancamento DOUBLE PRECISION NOT NULL,
                val_vinculado DOUBLE PRECISION NOT NULL,
                des_origem VARCHAR NOT NULL,
                fk_conta INTEGER NOT NULL,
                fk_classificacao INTEGER NOT NULL,
                CONSTRAINT id_lancamento PRIMARY KEY (id_lancamento)
);


CREATE TABLE public.titulos (
                id_titulos SERIAL NOT NULL,
                cod_titulos INTEGER NOT NULL,
                des_identificacao VARCHAR NOT NULL,
                dat_emissao DATE NOT NULL,
                dat_vencimento DATE NOT NULL,
                val_titulo DOUBLE PRECISION NOT NULL,
                des_observacao VARCHAR NOT NULL,
                opt_tipo VARCHAR NOT NULL,
                fk_classificacao INTEGER NOT NULL,
                fk_pessoa INTEGER NOT NULL,
                CONSTRAINT id_titulos PRIMARY KEY (id_titulos)
);


CREATE TABLE public.baixa (
                id_baixa SERIAL NOT NULL,
                dat_baixa DATE NOT NULL,
                val_desconto DOUBLE PRECISION NOT NULL,
                val_juros DOUBLE PRECISION NOT NULL,
                fk_titulos INTEGER NOT NULL,
                fk_lancamento INTEGER NOT NULL,
                CONSTRAINT id_baixa PRIMARY KEY (id_baixa)
);

CREATE TABLE public.usuario (
                id_usuario INTEGER NOT NULL,
                cod_usuario INTEGER NOT NULL,
                des_nome VARCHAR NOT NULL,
                val_login VARCHAR NOT NULL,
                val_senha VARCHAR NOT NULL,
                opt_tesoureiro VARCHAR NOT NULL,
                opt_desativado VARCHAR NOT NULL,
                CONSTRAINT id_usuario PRIMARY KEY (id_usuario)
);


ALTER TABLE public.lancamento ADD CONSTRAINT conta_lancamento_fk
FOREIGN KEY (fk_conta)
REFERENCES public.conta (id_conta)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.pessoa ADD CONSTRAINT endereco_pessoa_fk
FOREIGN KEY (fk_endereco)
REFERENCES public.endereco (id_endereco)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.fornecedor ADD CONSTRAINT pessoa_fornecedor_fk
FOREIGN KEY (fk_pessoa)
REFERENCES public.pessoa (id_pessoa)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cliente ADD CONSTRAINT pessoa_cliente_fk
FOREIGN KEY (fk_pessoa)
REFERENCES public.pessoa (id_pessoa)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.titulos ADD CONSTRAINT pessoa_titulos_fk
FOREIGN KEY (fk_pessoa)
REFERENCES public.pessoa (id_pessoa)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.titulos ADD CONSTRAINT classificacao_titulospagar_fk
FOREIGN KEY (fk_classificacao)
REFERENCES public.classificacao (id_classificacao)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.lancamento ADD CONSTRAINT classificacao_lancamento_fk
FOREIGN KEY (fk_classificacao)
REFERENCES public.classificacao (id_classificacao)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.baixa ADD CONSTRAINT lancamento_baixa_fk
FOREIGN KEY (fk_lancamento)
REFERENCES public.lancamento (id_lancamento)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.baixa ADD CONSTRAINT titulos_baixa_fk
FOREIGN KEY (fk_titulos)
REFERENCES public.titulos (id_titulos)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;