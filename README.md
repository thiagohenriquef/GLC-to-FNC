# Projeto2Teoria - Conversor de uma GLC-Simplificada para uma GLC na Forma Normal de Chomsky


Entrada ex: 
GR # identifica o tipo de formalismo
# Listagem das variáveis
4 # Número de variáveis
S # Variável 0 - A variável inicial é sempre a 0.
A # Variável 1
B # Variável 2
C # Variável 3
# Listagem dos terminais
3 # Número de símbolos terminais (sem incluir a palavra vazia (‘&’))
a # Variável 0
b # Variável 1
c # Variável 2
# Listagem de Regras de Produção
S # Lado esquerdo da produção S -> aAa
aAa # Lado direito da produção S -> aAa
S # Lado esquerdo da produção S -> bBb
bBb # Lado direito da produção S -> bBb
A # Lado esquerdo da produção A -> a
a # Lado direito da produção A -> a
A # Lado esquerdo da produção A -> b
b # Lado direito da produção A -> b
A # Lado esquerdo da produção A -> S
& # Lado direito da produção A -> &
C # Lado esquerdo da produção C -> c
c # Lado direito da produção C -> c



Saida ex:
GR # identifica o tipo de formalismo
# Listagem das variáveis
4 # Número de variáveis
S # Variável 0 - A variável inicial é sempre a 0.
A # Variável 1
B # Variável 2
C # Variável 3
# Listagem dos terminais
3 # Número de símbolos terminais (sem incluir a palavra vazia (‘&’))
a # Variável 0
b # Variável 1
c # Variável 2
# Listagem de Regras de Produção
S # Lado esquerdo da produção S -> aAa
aAa # Lado direito da produção S -> aAa
S # Lado esquerdo da produção S -> bBb
bBb # Lado direito da produção S -> bBb
A # Lado esquerdo da produção A -> a
a # Lado direito da produção A -> a
A # Lado esquerdo da produção A -> b
b # Lado direito da produção A -> b
A # Lado esquerdo da produção A -> S
& # Lado direito da produção A -> &
C # Lado esquerdo da produção C -> c
c # Lado direito da produção C -> c
