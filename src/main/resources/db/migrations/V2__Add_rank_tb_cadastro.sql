--V2: Migrations para adicionar rank em tb_cadastro
ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR (255);