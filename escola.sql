-- phpMyAdmin SQL Dump
-- version 4.7.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 10/10/2017 às 20:14
-- Versão do servidor: 10.1.26-MariaDB
-- Versão do PHP: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `escola`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `niveis_acesso`
--

CREATE TABLE `niveis_acesso` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `niveis_acesso`
--

INSERT INTO `niveis_acesso` (`id`, `nome`) VALUES
(1, 'Administrador'),
(2, 'Aluno'),
(3, 'Professor');

-- --------------------------------------------------------

--
-- Estrutura para tabela `situacao`
--

CREATE TABLE `situacao` (
  `id` int(11) NOT NULL,
  `situacao` varchar(50) NOT NULL,
  `created` date NOT NULL,
  `modified` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `situacao`
--

INSERT INTO `situacao` (`id`, `situacao`, `created`, `modified`) VALUES
(1, 'aceito', '2017-10-02', NULL),
(2, 'negado', '2017-10-02', NULL),
(3, 'pendente', '2017-10-02', NULL);

-- --------------------------------------------------------

--
-- Estrutura para tabela `tblAluno`
--

CREATE TABLE `tblAluno` (
  `idAluno` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `telAluno` char(10) NOT NULL,
  `endAluno` varchar(100) NOT NULL,
  `cpf` char(11) NOT NULL,
  `rg` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `tblAluno`
--

INSERT INTO `tblAluno` (`idAluno`, `nome`, `telAluno`, `endAluno`, `cpf`, `rg`) VALUES
(1, 'Lucas', '29255102', 'Rua 0102', '123456789', '987654321W');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tblDisciplina`
--

CREATE TABLE `tblDisciplina` (
  `idDisciplina` int(11) NOT NULL,
  `nomeDisciplina` varchar(255) NOT NULL,
  `descricaoDisciplina` varchar(255) NOT NULL,
  `diasDeAula` varchar(255) NOT NULL,
  `horario` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `tblDisciplina`
--

INSERT INTO `tblDisciplina` (`idDisciplina`, `nomeDisciplina`, `descricaoDisciplina`, `diasDeAula`, `horario`) VALUES
(1, 'PC', 'Aulas Voltadas para a aprendizagem da linguagem tecnologica Java', 'Quarta e Sexta', '19:00 e 21:00'),
(2, 'dcfsdf', 'dsçopçs', 'dsfsdfs', 'dsfsdfds'),
(3, '', '', '', '');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tblPedidos`
--

CREATE TABLE `tblPedidos` (
  `id` int(11) NOT NULL,
  `profCod` int(11) NOT NULL,
  `descricao` varchar(500) NOT NULL,
  `created` date NOT NULL,
  `modified` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `tblPedidos`
--

INSERT INTO `tblPedidos` (`id`, `profCod`, `descricao`, `created`, `modified`) VALUES
(1, 123, 'mudança de horario', '2017-10-03', NULL),
(2, 213131, 'sgsfgs', '0000-00-00', NULL),
(3, 1234, 'Gostaria de mudar de horario de aulas', '2017-10-09', NULL),
(4, 12344, 'Mudar nota de aluno', '2017-10-09', NULL),
(5, 313214123, 'Solicitação de mudança de aluno', '2012-10-02', NULL);

-- --------------------------------------------------------

--
-- Estrutura para tabela `tblProfessor`
--

CREATE TABLE `tblProfessor` (
  `idProfessor` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `telProfessor` char(10) NOT NULL,
  `endProfessor` varchar(100) NOT NULL,
  `cpf` char(11) NOT NULL,
  `rg` varchar(20) NOT NULL,
  `idDisciplina` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `tblProfessor`
--

INSERT INTO `tblProfessor` (`idProfessor`, `nome`, `telProfessor`, `endProfessor`, `cpf`, `rg`, `idDisciplina`) VALUES
(1, 'Jeferson', '1265765', 'Rua 0201', '2165762', '12321312s', 1),
(2, 'Wagner', '1312312423', 'sfsdsgsgs', '132423432', '2342342ff', 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `tblUser`
--

CREATE TABLE `tblUser` (
  `id` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `nivel_acesso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `tblUser`
--

INSERT INTO `tblUser` (`id`, `login`, `senha`, `nivel_acesso`) VALUES
(1, 'prof', '123', 3),
(2, 'admin', '1234', 1),
(3, 'joao', '12345', 2),
(4, 'batata', '123', 2);

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `niveis_acesso`
--
ALTER TABLE `niveis_acesso`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `situacao`
--
ALTER TABLE `situacao`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `tblAluno`
--
ALTER TABLE `tblAluno`
  ADD PRIMARY KEY (`idAluno`);

--
-- Índices de tabela `tblDisciplina`
--
ALTER TABLE `tblDisciplina`
  ADD PRIMARY KEY (`idDisciplina`);

--
-- Índices de tabela `tblPedidos`
--
ALTER TABLE `tblPedidos`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `tblProfessor`
--
ALTER TABLE `tblProfessor`
  ADD PRIMARY KEY (`idProfessor`),
  ADD KEY `idDisciplina` (`idDisciplina`);

--
-- Índices de tabela `tblUser`
--
ALTER TABLE `tblUser`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `niveis_acesso`
--
ALTER TABLE `niveis_acesso`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de tabela `situacao`
--
ALTER TABLE `situacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de tabela `tblAluno`
--
ALTER TABLE `tblAluno`
  MODIFY `idAluno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de tabela `tblDisciplina`
--
ALTER TABLE `tblDisciplina`
  MODIFY `idDisciplina` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de tabela `tblPedidos`
--
ALTER TABLE `tblPedidos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de tabela `tblProfessor`
--
ALTER TABLE `tblProfessor`
  MODIFY `idProfessor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de tabela `tblUser`
--
ALTER TABLE `tblUser`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
