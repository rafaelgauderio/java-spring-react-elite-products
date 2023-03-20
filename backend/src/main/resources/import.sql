INSERT INTO tb_embalagem(descricao) VALUES ('Fardo com 8 rolos');
INSERT INTO tb_embalagem(descricao) VALUES ('Fardo com 4 rolos');
INSERT INTO tb_embalagem(descricao) VALUES ('2.400 metros');
INSERT INTO tb_embalagem(descricao) VALUES ('2.000 metros');
INSERT INTO tb_embalagem(descricao) VALUES ('4.000 metros');
INSERT INTO tb_embalagem(descricao) VALUES ('Galão de 2 Litros');
INSERT INTO tb_embalagem(descricao) VALUES ('Galão de 5 Litros');
INSERT INTO tb_embalagem(descricao) VALUES ('Bombona de 20 Litros');

INSERT INTO tb_categoria(descricao) VALUES ('Papel Toalha');
INSERT INTO tb_categoria(descricao) VALUES ('Papel Higiênico');
INSERT INTO tb_categoria(descricao) VALUES ('Guardanapo');
INSERT INTO tb_categoria(descricao) VALUES ('Interfolhado');
INSERT INTO tb_categoria(descricao) VALUES ('Rolo');
INSERT INTO tb_categoria(descricao) VALUES ('Excellence');
INSERT INTO tb_categoria(descricao) VALUES ('Plus');
INSERT INTO tb_categoria(descricao) VALUES ('Classic');
INSERT INTO tb_categoria(descricao) VALUES ('Folha Simples');
INSERT INTO tb_categoria(descricao) VALUES ('Folha Dupla');
INSERT INTO tb_categoria(descricao) VALUES ('Folha Tripla');
INSERT INTO tb_categoria(descricao) VALUES ('Folha Quádrupla');

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


