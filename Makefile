# Universidade Federal de Minas Gerais
# Programacao Orientada a Objetos
# 2018-1
#
# Trabalho Pratico 1
# Sistema de Gerenciamento de Banco
#
# Andre Lage
# Augusto Mafra
#

COMPILE = javac
DEBUG = -g
DESTINY_DIR = .
BLOCK_WARNINGS = -Werror # Treat any compilation warning as error

.SUFFIXES: .java .class

.java.class:
	$(COMPILE) $(DEBUG) -d $(DESTINY_DIR) $(BLOCK_WARNINGS) $*.java

CONTA_DEPENDENCIES = banco/Cliente.java \
					 banco/Movimentacao.java

CONTA = banco/Conta.java

BANCO = banco/Banco.java

MAIN = Interface.java

all: $(MAIN:.java=.class)

$(MAIN:.java=.class): $(BANCO:.java=.class)

$(BANCO:.java=.class): $(CONTA:.java=.class)

$(CONTA:.java=.class): $(CONTA_DEPENDENCIES:.java=.class)

clean:
	$(RM) ./banco/*.class
	$(RM) ./*.class
