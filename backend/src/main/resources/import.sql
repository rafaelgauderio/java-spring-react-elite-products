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
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('1.120 metros', now()); --16
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('1.200 metros', now()); --17
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('1.600 metros', now()); --18
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('fardo com 6 rolos', now()); --19
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('caixa com 2.400 folhas', now()); --20
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('caixa com 4.800 folhas', now()); --21
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('caixa com 8.400 folhas', now()); --22
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('caixa com 5.250 folhas', now()); --23
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('caixa com 5.400 folhas', now()); --24
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('caixa com 7.200 folhas', now()); --25
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('caixa com 18.000 folhas', now()); --26
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('blader com 800 ml', now()); --27
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('blader com 1000 ml', now()); --28

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
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('amaciante', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('sabonete espuma', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('sabonete líquido', now()); --15
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('álcool', now()); --16

INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Rolo 7127','Papel higiênico em rolo 100% fibras virgens, Folha Dupla, Super Macio, Folhas Brancas',10.0, 2400, 'https://melhoramentoshigieners.com.br/imagens/7127.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z');
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Rolo 7111','Papel higiênico em rolo 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas',10.0, 4000, 'https://melhoramentoshigieners.com.br/imagens/7111.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z');
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Toalha Interfolhado 7234','Papel Toalha interfolhado 100% fibras virgens, Folha Quádrupla, Super Macio, Folhas Brancas, Tamanho da folha: 21 x 21 cm, Folhas por pacote: 150, Pacotes por caixa: 18',21.0, 2700, 'https://melhoramentoshigieners.com.br/imagens/7234.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z');

INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Rolo 7129','Papel higiênico em rolo 100% fibras virgens, Folha Dupla, Super Macio, Folhas Brancas',10.0, 2400, 'https://melhoramentoshigieners.com.br/imagens/7129.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --4
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Rolo 7138','Papel higiênico em rolo 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas',10.0, 2000, 'https://melhoramentoshigieners.com.br/imagens/7138.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --5
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Rolo 7132','Papel higiênico em rolo 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas',10.0,2400,'https://melhoramentoshigieners.com.br/imagens/7132.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --6
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Rolo 7133','Papel higiênico em rolo 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas',10.0,2400,'https://melhoramentoshigieners.com.br/imagens/7133.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --7
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Rolo 7139','Papel higiênico em rolo 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas',10.0,2000,'https://melhoramentoshigieners.com.br/imagens/7139.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --8
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Interfolhado 7124','Papel higiênico Interfolhado 100% fibras virgens, Folha Duplas, Super Macio, Folhas Brancas',21.0, 12000, 'https://melhoramentoshigieners.com.br/imagens/7124.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --9

INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico rolinho Sublime 1826','Papel higiênico rolinho Sublime 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas', 10.0,30,'https://melhoramentoshigieners.com.br/imagens/1826.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --10
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico rolinho Sublime 1710','Papel higiênico rolinho Sublime 100% fibras virgens, Folha Dupla, Super Macio, Folhas Brancas',10.0, 30,'https://melhoramentoshigieners.com.br/imagens/1710.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --11
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico rolinho Sublime 1735','Papel higiênico rolinho Sublime 100% fibras virgens, Folha Dupla, Super Macio, Folhas Brancas',10.0, 30,'https://melhoramentoshigieners.com.br/imagens/1735.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --12
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico rolinho Sublime 1510','Papel higiênico rolinho Sublime 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas',10.0, 30,'https://melhoramentoshigieners.com.br/imagens/1510.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --13
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico rolinho Sublime 1545','Papel higiênico rolinho Sublime 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas',10.0, 30,'https://melhoramentoshigieners.com.br/imagens/1545.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --14
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico rolinho Noble 1760','Papel higiênico rolinho Noble 100% fibras virgens, Folha Dupla, Super Macio, Folhas Brancas',10.0, 20,'https://melhoramentoshigieners.com.br/imagens/1760.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --15

INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Toalha Rolo 7242','Papel Toalha Rolo 100% fibras virgens, Folha Tripla, Super Macio, Folhas Brancas, Metragem de cada rolo: 140 metros',19.1,1120, 'https://melhoramentoshigieners.com.br/imagens/7242.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --16
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Toalha Rolo 7244','Papel Toalha Rolo 100% fibras virgens, Folha Dupla, Super Macio, Folhas Brancas, Metragem de cada rolo: 200 metros',19.1,1600, 'https://melhoramentoshigieners.com.br/imagens/7244.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --17
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Toalha Rolo 7215','Papel Toalha Rolo 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas, Metragem de cada rolo: 200 metros',19.1,1600, 'https://melhoramentoshigieners.com.br/imagens/7215.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --18
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Toalha Rolo 7235','Papel Toalha Rolo 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas, Metragem de cada rolo: 200 metros',19.1,1200, 'https://melhoramentoshigieners.com.br/imagens/7235.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --19
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Toalha Rolo 7230','Papel Toalha Rolo 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas, Metragem de cada rolo: 250 metros',19.1,2000, 'https://melhoramentoshigieners.com.br/imagens/7230.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --20

INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Toalha Interfolhado 7243','Papel Toalha interfolhado 100% fibras virgens, Folha Tripla, Super Macio, Folhas Brancas, Tamanho da folha: 21 x 21 cm, Folhas por pacote: 150, Pacotes por caixa: 18',21.0, 2700, 'https://melhoramentoshigieners.com.br/imagens/7243.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --21
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Toalha Interfolhado 7210','Papel Toalha interfolhado 100% fibras virgens, Folha Dupla, Super Macio, Folhas Brancas, Tamanho da folha: 21 x 21 cm, Folhas por pacote: 200, Pacotes por caixa: 12',21.0, 2400, 'https://melhoramentoshigieners.com.br/imagens/7210.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --22
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Toalha Interfolhado 7208','Papel Toalha interfolhado 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas, Tamanho da folha: 21 x 19 cm, Folhas por pacote: 320, Pacotes por caixa: 15',21.0, 4800, 'https://melhoramentoshigieners.com.br/imagens/7208.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --23
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Toalha Interfolhado 7216','Papel Toalha interfolhado 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas, Tamanho da folha: 21 x 29 cm, Folhas por pacote: 350, Pacotes por caixa: 24',21.0, 8400, 'https://melhoramentoshigieners.com.br/imagens/7216.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --24
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Toalha Interfolhado 7229','Papel Toalha interfolhado 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas, Tamanho da folha: 21 x 18.8 cm, Folhas por pacote: 350, Pacotes por caixa: 15',21.0, 5250, 'https://melhoramentoshigieners.com.br/imagens/7229.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --25
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Toalha Interfolhado 7240','Papel Toalha interfolhado 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas, Tamanho da folha: 20 x 21 cm, Folhas por pacote: 1000, Pacotes por caixa: 12',20.0, 12000, 'https://melhoramentoshigieners.com.br/imagens/7240.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --26

INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Guardanapo Interfolhado 7306','Guardanapo Interfolhado 100% fibras virgens, Folha Dupla, Super Macio, Folhas Brancas, Tamanho da folha: 14.5 x 21 cm, Folhas por pacote: 300, Pacotes por caixa: 18',14.5, 5400, 'https://melhoramentoshigieners.com.br/imagens/7306.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --27
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Guardanapo Interfolhado 7308','Guardanapo Interfolhado 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas, Tamanho da folha: 14.5 x 21 cm, Folhas por pacote: 300, Pacotes por caixa: 18',14.5, 5400, 'https://melhoramentoshigieners.com.br/imagens/7308.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --28
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Guardanapo Interfolhado 7305','Guardanapo Interfolhado 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas, Tamanho da folha: 14.5 x 21 cm, Folhas por pacote: 300, Pacotes por caixa: 24',14.5, 7200, 'https://melhoramentoshigieners.com.br/imagens/7305.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --29
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Guardanapo Interfolhado 7532','Guardanapo Interfolhado 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas, Tamanho da folha: 10 x 21 cm, Folhas por pacote: 250, Pacotes por caixa: 72',10.0, 18000, 'https://melhoramentoshigieners.com.br/imagens/7532.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --30

-- sabonetes espuma
INSERT INTO tb_produto(descricao, descricao_completa, fragrancia, img_url, data_cadastro) VALUES ('Sabonete Espuma Violeta 7491','Sabonete Espuma Violeta com fragrância de cereja e avelã, blader por caixa: 6','Cereja e Avelã', 'https://melhoramentoshigieners.com.br/imagens/7491.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --31
INSERT INTO tb_produto(descricao, descricao_completa, fragrancia, img_url, data_cadastro) VALUES ('Sabonete Espuma Antisséptico 7492','Sabonete Espuma Antisséptico biguanida polimérica, blader por caixa: 6','Odor Alcoólico', 'https://melhoramentoshigieners.com.br/imagens/7492.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --32
INSERT INTO tb_produto(descricao, descricao_completa, fragrancia, img_url, data_cadastro) VALUES ('Sabonete Espuma Bactericida 7467','Sabonete Espuma Bactericida quaternário de 5ª geração, blader por caixa: 6','Sem Fragrância', 'https://melhoramentoshigieners.com.br/imagens/7467.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --33
INSERT INTO tb_produto(descricao, descricao_completa, fragrancia, img_url, data_cadastro) VALUES ('Sabonete Espuma Bactericida 7466','Sabonete Espuma Bactericida clorexidina, blader por caixa: 6','Sem Fragrância','https://melhoramentoshigieners.com.br/imagens/7466.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --34

-- sabonete líquido
INSERT INTO tb_produto(descricao, descricao_completa, fragrancia, img_url, data_cadastro) VALUES ('Sabonete Líquido Bactericida 7487', 'Sabonete Líquido Bactericida Triclosan, blader por caixa: 6','Sem Fragrância', 'https://melhoramentoshigieners.com.br/imagens/7487.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --35
INSERT INTO tb_produto(descricao, descricao_completa, fragrancia, img_url, data_cadastro) VALUES ('Sabonete Líquido Floral 7488', 'Sabonete Líquido Floral, blader por caixa: 6','Floral', 'https://melhoramentoshigieners.com.br/imagens/7488.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --36
INSERT INTO tb_produto(descricao, descricao_completa, fragrancia, img_url, data_cadastro) VALUES ('Sabonete Líquido Erva Doce 7471', 'Sabonete Líquido Erva Doce, blader por caixa: 6','Erva Doce', 'https://melhoramentoshigieners.com.br/imagens/7471.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --37
INSERT INTO tb_produto(descricao, descricao_completa, fragrancia, img_url, data_cadastro) VALUES ('Sabonete Líquido Cereja e Avelã 7489', 'Sabonete Líquido Cereja e Avelã  blader por caixa: 6','Cereja e Avelã', 'https://melhoramentoshigieners.com.br/imagens/7489.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --38
INSERT INTO tb_produto(descricao, descricao_completa, fragrancia, img_url, data_cadastro) VALUES ('Sabonete Líquido Ervas Finas 7490', 'Sabonete Líquido Ervas Finas, blader por caixa: 6','Ervas Finas', 'https://melhoramentoshigieners.com.br/imagens/7490.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --39

-- alcool espuma e gel
INSERT INTO tb_produto(descricao, descricao_completa, fragrancia, img_url, data_cadastro) VALUES ('Álcool Espuma 7493', 'Álcool Antisséptico de Mãos Espuma, blader por caixa: 6','Alcoólico', 'https://melhoramentoshigieners.com.br/imagens/7493.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --40
INSERT INTO tb_produto(descricao, descricao_completa, fragrancia, img_url, data_cadastro) VALUES ('Álcool Espuma 7463', 'Espuma Higienizadora, blader por caixa: 6','Alcoólico', 'https://melhoramentoshigieners.com.br/imagens/7463.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --41
INSERT INTO tb_produto(descricao, descricao_completa, fragrancia, img_url, data_cadastro) VALUES ('Álcool Gel 7494', 'Álcool Antisséptico de Mãos Gel, blader por caixa: 6','Alcoólico', 'https://melhoramentoshigieners.com.br/imagens/7494.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --42
INSERT INTO tb_produto(descricao, descricao_completa, fragrancia, img_url, data_cadastro) VALUES ('Álcool Gel 7434', 'Álcool Gel Higienizador, blader por caixa: 6','Alcoólico', 'https://melhoramentoshigieners.com.br/imagens/7434.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z'); --43


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
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (16,1);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (16,16);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (17,1);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (17,18);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (18,1);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (18,18);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (19,19);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (19,17);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (20,1);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (20,18);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (21,6);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (22,20);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (23,21);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (24,22);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (25,23);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (26,7);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (27,24);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (28,24);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (29,25);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (30,26);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (31,27);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (32,27);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (33,27);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (34,27);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (35,27);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (36,27);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (37,28);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (38,27);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (39,27);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (40,27);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (41,27);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (42,27);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (43,27);

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

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (16,1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (16,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (16,6);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (16,11);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (17,1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (17,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (17,7);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (17,10);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (18,1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (18,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (18,7);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (18,9);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (19,1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (19,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (19,7);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (19,9);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (20,1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (20,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (20,8);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (20,9);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (21,1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (21,4);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (21,6);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (21,11);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (22,1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (22,4);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (22,7);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (22,10);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (23,1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (23,4);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (23,7);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (23,9);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (24,1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (24,4);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (24,7);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (24,9);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (25,1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (25,4);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (25,8);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (25,9);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (26,1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (26,4);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (26,8);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (26,9);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (27,3);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (27,4);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (27,6);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (27,10);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (28,3);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (28,4);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (28,7);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (28,9);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (29,3);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (29,4);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (29,7);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (29,9);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (30,3);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (30,4);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (30,8);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (30,9);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (31,14);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (31,6);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (32,14);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (32,6);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (33,14);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (33,6);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (34,14);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (34,6);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (35,15);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (35,7);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (36,15)
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (36,7);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (37,15);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (37,7);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (38,15);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (38,8);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (39,15);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (39,8);


INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (40,16);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (40,6);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (41,16);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (41,6);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (42,16);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (42,7);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (43,16);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (43,7);


INSERT INTO tb_usuario(nome, sobrenome, email, password) VALUES ('Rafael' , 'De Luca','rafaeldeluca@gmail.com','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_usuario(nome, sobrenome, email, password) VALUES ('Maria' , 'da Silva','mariadasilva@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_usuario(nome, sobrenome, email, password) VALUES ('Juliana' , 'da Silva','julianadasilva@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_usuario(nome, sobrenome, email, password) VALUES ('Claudia' , 'da Silva','claudiadasilva@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_regra (descricao, permissao) VALUES ('Tem permissao de CRUD em usuários','ROLE_ADMIN_SISTEMA');
INSERT INTO tb_regra (descricao, permissao) VALUES ('Tem permissao de CRUD em produtos, embalagens e categorias.','ROLE_GERENTE_LOJA');
INSERT INTO tb_regra (descricao, permissao) VALUES ('Tem permissao apenas de envias SMS','ROLE_CONSULTOR');

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