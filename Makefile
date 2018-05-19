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

SOURCE = Banco.java \
		 Interface.java

all: classes

classes: $(SOURCE:.java=.class)

clean:
	$(RM) ./*.class
