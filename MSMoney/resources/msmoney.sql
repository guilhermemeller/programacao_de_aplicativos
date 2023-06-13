-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 14/06/2023 às 01:02
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `msmoney`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `categoria`
--

CREATE TABLE `categoria` (
  `nome_categoria` varchar(240) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `usuario_id` int(240) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `categoria`
--

INSERT INTO `categoria` (`nome_categoria`, `id_categoria`, `usuario_id`) VALUES
('Teste', 20, 13),
('Salário', 23, 12),
('Automóvel', 24, 12);

-- --------------------------------------------------------

--
-- Estrutura para tabela `fundo_despesas`
--

CREATE TABLE `fundo_despesas` (
  `id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `nome` varchar(240) NOT NULL,
  `total` double(10,2) NOT NULL,
  `tipo` varchar(240) NOT NULL,
  `mes` int(11) NOT NULL,
  `ano` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `fundo_despesas`
--

INSERT INTO `fundo_despesas` (`id`, `usuario_id`, `nome`, `total`, `tipo`, `mes`, `ano`) VALUES
(133, 12, 'Poupança', 5000.00, 'Fundo para Despesas Ocasionais', 1, 2023),
(134, 12, 'Poupança', 5000.00, 'Fundo para Despesas Ocasionais', 2, 2023),
(135, 12, 'Poupança', 5000.00, 'Fundo para Despesas Ocasionais', 3, 2023),
(136, 12, 'Poupança', 5000.00, 'Fundo para Despesas Ocasionais', 4, 2023),
(137, 12, 'Poupança', 5000.00, 'Fundo para Despesas Ocasionais', 5, 2023),
(138, 12, 'Poupança', 5000.00, 'Fundo para Despesas Ocasionais', 6, 2023),
(139, 12, 'Poupança', 5000.00, 'Fundo para Despesas Ocasionais', 7, 2023),
(140, 12, 'Poupança', 5000.00, 'Fundo para Despesas Ocasionais', 8, 2023),
(141, 12, 'Poupança', 5000.00, 'Fundo para Despesas Ocasionais', 9, 2023),
(142, 12, 'Poupança', 5000.00, 'Fundo para Despesas Ocasionais', 10, 2023),
(143, 12, 'Poupança', 5000.00, 'Fundo para Despesas Ocasionais', 11, 2023),
(144, 12, 'Poupança', 5000.00, 'Fundo para Despesas Ocasionais', 12, 2023);

-- --------------------------------------------------------

--
-- Estrutura para tabela `investimento`
--

CREATE TABLE `investimento` (
  `id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `nome` varchar(240) NOT NULL,
  `mensal_ocasional` tinyint(1) NOT NULL,
  `total` double(10,2) NOT NULL,
  `tipo` varchar(240) NOT NULL,
  `mes` int(11) NOT NULL,
  `ano` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `rendimento_despesa`
--

CREATE TABLE `rendimento_despesa` (
  `id` int(11) NOT NULL,
  `usuario_id` int(240) NOT NULL,
  `nome` varchar(240) NOT NULL,
  `categoria` int(11) NOT NULL,
  `mensal_ocasional` tinyint(1) NOT NULL,
  `total` double(10,2) NOT NULL,
  `tipo` varchar(240) NOT NULL,
  `mes` int(11) NOT NULL,
  `ano` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `rendimento_despesa`
--

INSERT INTO `rendimento_despesa` (`id`, `usuario_id`, `nome`, `categoria`, `mensal_ocasional`, `total`, `tipo`, `mes`, `ano`) VALUES
(463, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 1, 2023),
(464, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 2, 2023),
(465, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 3, 2023),
(466, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 4, 2023),
(467, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 5, 2023),
(468, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 6, 2023),
(469, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 7, 2023),
(470, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 8, 2023),
(471, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 9, 2023),
(472, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 10, 2023),
(473, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 11, 2023),
(474, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 12, 2023),
(475, 12, 'Gasolina', 24, 1, 200.00, 'Despesa', 1, 2023),
(476, 12, 'Gasolina', 24, 1, 200.00, 'Despesa', 2, 2023),
(477, 12, 'Gasolina', 24, 1, 200.00, 'Despesa', 3, 2023),
(478, 12, 'Gasolina', 24, 1, 200.00, 'Despesa', 4, 2023),
(479, 12, 'Gasolina', 24, 1, 200.00, 'Despesa', 5, 2023),
(480, 12, 'Gasolina', 24, 1, 200.00, 'Despesa', 6, 2023),
(481, 12, 'Gasolina', 24, 1, 200.00, 'Despesa', 7, 2023),
(482, 12, 'Gasolina', 24, 1, 200.00, 'Despesa', 8, 2023),
(483, 12, 'Gasolina', 24, 1, 200.00, 'Despesa', 9, 2023),
(484, 12, 'Gasolina', 24, 1, 200.00, 'Despesa', 10, 2023),
(485, 12, 'Gasolina', 24, 1, 200.00, 'Despesa', 11, 2023),
(486, 12, 'Gasolina', 24, 1, 200.00, 'Despesa', 12, 2023),
(487, 12, 'Manutenção', 24, 1, 1500.00, 'Despesa', 1, 2024),
(488, 12, 'Manutenção', 24, 1, 1500.00, 'Despesa', 2, 2024),
(489, 12, 'Manutenção', 24, 1, 1500.00, 'Despesa', 3, 2024),
(490, 12, 'Manutenção', 24, 1, 1500.00, 'Despesa', 4, 2024),
(491, 12, 'Manutenção', 24, 1, 1500.00, 'Despesa', 5, 2024),
(492, 12, 'Manutenção', 24, 1, 1500.00, 'Despesa', 6, 2024),
(493, 12, 'Manutenção', 24, 1, 1500.00, 'Despesa', 7, 2024),
(494, 12, 'Manutenção', 24, 1, 1500.00, 'Despesa', 8, 2024),
(495, 12, 'Manutenção', 24, 1, 1500.00, 'Despesa', 9, 2024),
(496, 12, 'Manutenção', 24, 1, 1500.00, 'Despesa', 10, 2024),
(497, 12, 'Manutenção', 24, 1, 1500.00, 'Despesa', 11, 2024),
(498, 12, 'Manutenção', 24, 1, 1500.00, 'Despesa', 12, 2024),
(499, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 1, 2024),
(500, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 2, 2024),
(501, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 3, 2024),
(502, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 4, 2024),
(503, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 5, 2024),
(504, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 6, 2024),
(505, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 7, 2024),
(506, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 8, 2024),
(507, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 9, 2024),
(508, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 10, 2024),
(509, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 11, 2024),
(510, 12, 'Salário Mensal', 23, 1, 5000.00, 'Rendimento', 12, 2024);

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `login` varchar(240) NOT NULL,
  `senha` varchar(240) NOT NULL,
  `nome` varchar(240) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `usuario`
--

INSERT INTO `usuario` (`id`, `login`, `senha`, `nome`) VALUES
(12, 'mitz', '123', 'Matheus'),
(13, 'mitz2', '123', 'Matheus');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`),
  ADD KEY `usuario_id_fk` (`usuario_id`);

--
-- Índices de tabela `fundo_despesas`
--
ALTER TABLE `fundo_despesas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuario_fk` (`usuario_id`);

--
-- Índices de tabela `investimento`
--
ALTER TABLE `investimento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuario_fk` (`usuario_id`);

--
-- Índices de tabela `rendimento_despesa`
--
ALTER TABLE `rendimento_despesa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuario_id_fk` (`usuario_id`),
  ADD KEY `id_categoria_fk` (`categoria`);

--
-- Índices de tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de tabela `fundo_despesas`
--
ALTER TABLE `fundo_despesas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=145;

--
-- AUTO_INCREMENT de tabela `investimento`
--
ALTER TABLE `investimento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=89;

--
-- AUTO_INCREMENT de tabela `rendimento_despesa`
--
ALTER TABLE `rendimento_despesa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=511;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `categoria`
--
ALTER TABLE `categoria`
  ADD CONSTRAINT `categoria_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `fundo_despesas`
--
ALTER TABLE `fundo_despesas`
  ADD CONSTRAINT `fundo_despesas_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `investimento`
--
ALTER TABLE `investimento`
  ADD CONSTRAINT `investimento_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `rendimento_despesa`
--
ALTER TABLE `rendimento_despesa`
  ADD CONSTRAINT `rendimento_despesa_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rendimento_despesa_ibfk_2` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`id_categoria`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
