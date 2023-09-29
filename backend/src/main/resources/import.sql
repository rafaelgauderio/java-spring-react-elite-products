INSERT INTO tb_embalagem(descricao , data_insercao) VALUES ('fardo com 8 rolos', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('fardo com 4 rolos' , now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('2.400 metros', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('2.000 metros', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('4.000 metros', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('caixa com 2.700 folhas', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('caixa com 12.000 folhas', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('fardo com 12 rolos', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('fardo com 16 rolos', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('caixa com 8 fardos', now()); -- 10
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('caixa com 10 fardos', now()); --11
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('caixa com 16 fardos', now()); --12
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('galão de 2 litros', now()); --13
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('galão de 5 litros', now()); --14
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('bombona de 20 litros', now()); --15

INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('papel toalha', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('papel higiênico', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('guardanapo', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('interfolhado', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('rolo', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('excellence (luxo)', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('plus (intermediária)', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('classic (econômica)', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('folha simples', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('folha dupla', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('folha tripla', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('folha quádrupla', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('Amaciante', now());

INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Rolo 7127','Papel higiênico em rolo 100% fibras virgens, Folha Dupla, Super Macio, Folhas Brancas',10.0, 2400, 'https://melhoramentoshigieners.com.br/imagens/7127.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z');
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Rolo 7111','Papel higiênico em rolo 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas',10.0, 4000, 'https://melhoramentoshigieners.com.br/imagens/7111.jpg', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z');
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Toalha Interfolhado 7234','Papel Toalha interfolhado 100% fibras virgens, Folha Quádrupla, Super Macio, Folhas Brancas, Tamanho da folha: 21 x 21 cm, Folhas por pacote: 150, Pacotes por caixa: 18',21.0, 2700, 'https://melhoramentoshigieners.com.br/imagens/7234.jpg', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z');

INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Rolo 7129','Papel higiênico em rolo 100% fibras virgens, Folha Dupla, Super Macio, Folhas Brancas',10.0, 2400, 'https://melhoramentoshigieners.com.br/imagens/7127.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --4
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Rolo 7138','Papel higiênico em rolo 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas',10.0, 2000, 'https://melhoramentoshigieners.com.br/imagens/7111.jpg', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --5
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Rolo 7132','Papel higiênico em rolo 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas',10.0,2400,'https://melhoramentoshigieners.com.br/imagens/7111.jpg', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --6
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Rolo 7133','Papel higiênico em rolo 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas',10.0,2400,'https://melhoramentoshigieners.com.br/imagens/7111.jpg', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --7
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Rolo 7139','Papel higiênico em rolo 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas',10.0,2000,'https://melhoramentoshigieners.com.br/imagens/7111.jpg', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --8
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Interfolhado 7124','Papel higiênico Interfolhado 100% fibras virgens, Folha Duplas, Super Macio, Folhas Brancas',21.0, 12000, 'https://melhoramentoshigieners.com.br/imagens/7127.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --9

INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Sublime rolinho 1826','Papel higiênico rolinho Sublime 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas', 10.0,30,'https://melhoramentoshigieners.com.br/imagens/7111.jpg', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --10
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Sublime rolinho 1710','Papel higiênico rolinho Sublime 100% fibras virgens, Folha Dupla, Super Macio, Folhas Brancas',10.0, 30,'https://melhoramentoshigieners.com.br/imagens/7127.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --11
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Sublime rolinho 1735','Papel higiênico rolinho Sublime 100% fibras virgens, Folha Dupla, Super Macio, Folhas Brancas',10.0, 30,'https://melhoramentoshigieners.com.br/imagens/7111.jpg', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --12
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Sublime rolinho 1510','Papel higiênico rolinho Sublime 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas',10.0, 30,'https://melhoramentoshigieners.com.br/imagens/7127.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --13
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Sublime rolinho 1545','Papel higiênico rolinho Sublime 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas',10.0, 30,'https://melhoramentoshigieners.com.br/imagens/7127.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --14
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Noble rolinho 1760','Papel higiênico rolinho Noble 100% fibras virgens, Folha Dupla, Super Macio, Folhas Brancas',10.0, 20,'https://melhoramentoshigieners.com.br/imagens/7127.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --15

INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (1,1);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (1,3);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (2,1);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (2,5);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (3,6);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (4,3);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (4,9);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (5,2);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (5,4);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (6,1);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (6,3);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (7,1);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (7,3);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (8,2);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (8,4);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (9,7);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (10,12);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (10,2);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (11,12);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (11,2);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (12,10);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (12,8);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (13,12);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (13,2);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (14,11);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (14,8);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (15,8);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (15,11);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (1,2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (1,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (1,6);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (1,10);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (2,2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (2,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (2,7);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (2,9);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (3,1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (3,4);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (3,6);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (3,12);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (4,2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (4,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (4,6);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (4,10);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (5,2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (5,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (5,7);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (5,9);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (6,2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (6,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (6,7);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (6,9);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (7,2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (7,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (7,8);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (7,9);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (8,2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (8,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (8,8);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (8,9);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (9,2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (9,4);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (9,6);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (9,10);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (10,2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (10,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (10,6);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (10,10);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (11,2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (11,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (11,7);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (11,10);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (12,2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (12,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (12,7);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (12,10);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (13,2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (13,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (13,8);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (13,9);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (14,2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (14,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (14,8);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (14,9);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (15,2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (15,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (15,7);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (15,10);


INSERT INTO tb_usuario(nome, sobrenome, email, password) VALUES ('Rafael' , 'De Luca','rafaeldeluca@gmail.com','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_usuario(nome, sobrenome, email, password) VALUES ('Maria' , 'da Silva','mariadasilva@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_usuario(nome, sobrenome, email, password) VALUES ('Juliana' , 'de Silva','julianadesilva@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_usuario(nome, sobrenome, email, password) VALUES ('Claudia' , 'da Silva','claudiadasilva@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_regra (descricao, permissao) VALUES ('Tem todas as permissoes de CRUD. Acesso a todas as rotas.','ROLE_ADMIN_SISTEMA');
INSERT INTO tb_regra (descricao, permissao) VALUES ('Tem permissao de CRUD em algumas entidades. Não tem permissao de CRUD de usuarios e regras de acesso.','ROLE_GERENTE_LOJA');
INSERT INTO tb_regra (descricao, permissao) VALUES ('Tem permissao de GET em todos as rotas e envio de sms','ROLE_CLIENTE');

INSERT INTO tb_usuario_regra (usuario_id, regra_id) VALUES (1,1);
INSERT INTO tb_usuario_regra (usuario_id, regra_id) VALUES (1,2);
INSERT INTO tb_usuario_regra (usuario_id, regra_id) VALUES (2,1);
INSERT INTO tb_usuario_regra (usuario_id, regra_id) VALUES (3,2);
INSERT INTO tb_usuario_regra (usuario_id, regra_id) VALUES (4,3);


INSERT INTO tb_departamento (nome) VALUES ('Tecnologia da Informação');
INSERT INTO tb_departamento (nome) VALUES ('Vendas Interno');
INSERT INTO tb_departamento (nome) VALUES ('Vendas Externo');
INSERT INTO tb_departamento (nome) VALUES ('Faturamento');
INSERT INTO tb_departamento (nome) VALUES ('Compras');
INSERT INTO tb_departamento (nome) VALUES ('Logística');
INSERT INTO tb_departamento (nome) VALUES ('Contas a Pagar');
INSERT INTO tb_departamento (nome) VALUES ('Contas a Receber');
INSERT INTO tb_departamento (nome) VALUES ('Recursos Humanos');

INSERT INTO tb_colaborador (nome, telefone, email, departamento_id) VALUES ('Rafael de Luca','5133736800','redes@melhoramentoshigieners.com.br', 1);
INSERT INTO tb_colaborador (nome, telefone, email, departamento_id) VALUES ('Mylene','5133736801','vendas02@melhoramentoshigieners.com.br', 2)
INSERT INTO tb_colaborador (nome, telefone, email, departamento_id) VALUES ('Alexandre','5133736805','vendas01@melhoramentoshigieners.com.br', 2);
INSERT INTO tb_colaborador (nome, telefone, email, departamento_id) VALUES ('Angelo', '5133736802', 'vendas07@melhoramentoshigieners.com.br',2);
INSERT INTO tb_colaborador (nome, telefone, email, departamento_id) VALUES ('Fernanda', '5133736813', 'compras@melhoramentoshigieners.com.br',5);
INSERT INTO tb_colaborador (nome, telefone, email, departamento_id) VALUES ('Fernanda', '5133736813', 'controladoria@melhoramentoshigieners.com.br',7);
INSERT INTO tb_colaborador (nome, telefone, email, departamento_id) VALUES ('Carolina', '5133736808', 'faturamento@melhoramentoshigieners.com.br',5);
INSERT INTO tb_colaborador (nome, telefone, email, departamento_id) VALUES ('Carolina', '5133736809', 'cobranca@melhoramentoshigieners.com.br',8);
INSERT INTO tb_colaborador (nome, telefone, email, departamento_id) VALUES ('Marco', '5133736812', 'rh@melhoramentoshigieners.com.br',9);
INSERT INTO tb_colaborador (nome, telefone, email, departamento_id) VALUES ('Dênio', '5133736835', 'logistica@melhoramentoshigieners.com.br',6);





