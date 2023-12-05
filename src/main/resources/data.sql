-- Insere hotéis
INSERT INTO tb_hotel (id, nome, endereco, estado, estrelas) VALUES
('0c8e5f9a-7185-4679-9f91-c0d88082f114', 'Hotel Maravilha', 'Caminho das Águas 994', 'São Paulo', 5),
('dd9649a8-d5dc-4c88-98a8-d4ba190bb594', 'Hotel Aconchego', 'Largo dos Pioneiros 716', 'Rio de Janeiro', 4),
('53c6bf1d-ec68-4c51-a8a8-03b2c1e2697d', 'Hotel Recanto', 'Rua das Orquídeas 683', 'Recife', 3);

-- Insere quartos no Hotel Maravilha
INSERT INTO tb_quarto (id, preco, quantidade_cama_solteiro, quantidade_cama_casal, quantidade_beliche, categoria, status_quarto, hotel_id) VALUES
('8de70611-8271-4ce5-ad76-bcaf501a43b2', 250.0, 2, 1, 0, 'ECONOMICO', 'DISPONIVEL', '0c8e5f9a-7185-4679-9f91-c0d88082f114'),
('ac3ea3ec-e4a1-4088-8474-6c49ac154ac6', 500.0, 0, 2, 0, 'LUXO', 'DISPONIVEL', '0c8e5f9a-7185-4679-9f91-c0d88082f114');

-- Insere quartos no Hotel Aconchego
INSERT INTO tb_quarto (id, preco, quantidade_cama_solteiro, quantidade_cama_casal, quantidade_beliche, categoria, status_quarto, hotel_id) VALUES
('d9970870-9d79-462e-b958-0d1b1a64bcda', 200.0, 1, 1, 1, 'BARATO', 'DISPONIVEL', 'dd9649a8-d5dc-4c88-98a8-d4ba190bb594'),
('1e37e096-3f9a-4531-bfd8-be525388248e', 450.0, 0, 1, 0, 'ECONOMICO', 'DISPONIVEL', 'dd9649a8-d5dc-4c88-98a8-d4ba190bb594');

-- Insere quartos no Hotel Recanto
INSERT INTO tb_quarto (id, preco, quantidade_cama_solteiro, quantidade_cama_casal, quantidade_beliche, categoria, status_quarto, hotel_id) VALUES
('2399e856-41c5-4e8c-81a0-6ecc75d9ffbd', 300.0, 1, 1, 0, 'BARATO', 'DISPONIVEL', '53c6bf1d-ec68-4c51-a8a8-03b2c1e2697d'),
('e0eeee4e-9b05-4998-9a04-b168e024e388', 550.0, 0, 2, 0, 'LUXO', 'DISPONIVEL', '53c6bf1d-ec68-4c51-a8a8-03b2c1e2697d');