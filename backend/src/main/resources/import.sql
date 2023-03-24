INSERT INTO tb_embalagem(descricao , data_insercao) VALUES ('Fardo com 8 rolos', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('Fardo com 4 rolos' , now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('2.400 metros', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('2.000 metros', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('4.000 metros', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('Galão de 2 Litros', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('Galão de 5 Litros', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('Bombona de 20 Litros', now());

INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('Papel Toalha', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('Papel Higiênico', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('Guardanapo', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('Interfolhado', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('Rolo', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('Excellence', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('Plus', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('Classic', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('Folha Simples', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('Folha Dupla', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('Folha Tripla', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('Folha Quádrupla', now());

INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Rolo 7127','Papel higiênico em rolo 100% fibras virgens, Folha Dupla, Super Macio, Folhas Brancas',10.0, 300, 'https://melhoramentoshigienrs.com.br/imagens/7127.jpg', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z');
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Rolo 7111','Papel higiênico em rolo 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas',10.0, 500, 'https://melhoramentoshigienrs.com.br/imagens/7111.jpg', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z');

INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (1,1);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (1,3);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (2,1);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (2,5);


INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (1,2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (1,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (1,6);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (1,10);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (2,2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (2,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (2,7);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (2,9);

INSERT INTO tb_usuario(nome, sobrenome, email, password) VALUES ('Rafael' , 'De Luca','rafaeldeluca@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_regra (descricao, permissao) VALUES ('Tem todas as permissoes de CRUD. Acesso a todas as rotas.','ADMIN_USUARIOS');

INSERT INTO tb_usuario_regra (usuario_id, regra_id) VALUES (1,1);
