import random
import time


equipes = {
    "Mercedes": ["Lewis Hamilton", "George Russell"],
    "RBR": ["Max Verstappen", "Sergio Perez"],
    "McLaren": ["Daniel Ricciardo", "Lando Norris"],
    "Ferrari": ["Carlos Sainz", "Charles Leclerc"],
    "Aston Martin": ["Sebastian Vettel", "Lance Stroll"],
    "Renault": ["Fernando Alonso", "Esteban Ocon"],
    "Haas": ["Nikita Mazepin", "Mick Schumacher"],
    "Williams": ["Nicholas Latifi", "Alexander Albon"],
    "Alfa Romeo": ["Guanyu Zhou", "Valtteri Bottas"],
    "AlphaTauri": ["Pierre Gasly", "Yuki Tsunoda"],
}


tabela_hash_pontuacoes_pilotos = {piloto: 0 for equipe in equipes.values() for piloto in equipe}
tabela_hash_pontuacoes_equipes = {equipe: 0 for equipe in equipes}


def simular_volta_quick_sort_hash(tabela_hash_pilotos):
    pilotos = list(tabela_hash_pilotos.keys())
    random.shuffle(pilotos)  
    return pilotos

num_etapas = 22
num_voltas_por_etapa = 60

start_time = time.time()

for etapa in range(1, num_etapas + 1):
    print(f"\nEtapa {etapa}")

   
    pontuacoes_etapa_pilotos = {piloto: 0 for piloto in tabela_hash_pontuacoes_pilotos}
    pontuacoes_etapa_equipes = {equipe: 0 for equipe in equipes}

    for volta in range(1, num_voltas_por_etapa + 1):


        grid_corrida = simular_volta_quick_sort_hash(tabela_hash_pontuacoes_pilotos)

        
        if volta == num_voltas_por_etapa:
            print("\nÚltima Volta - Pódio:")
            for posicao, piloto in enumerate(grid_corrida[:3], start=1):
                equipe = [equipe for equipe, pilotos in equipes.items() if piloto in pilotos][0]
                print(f"{posicao}º lugar - {piloto} ({equipe})")

           
            for posicao, piloto in enumerate(grid_corrida[:10], start=1):
                pontuacao = [25, 18, 15, 12, 10, 8, 6, 4, 2, 1][posicao - 1]
                pontuacoes_etapa_pilotos[piloto] += pontuacao


    for equipe, pilotos in equipes.items():
        pontuacao_equipe = sum(pontuacoes_etapa_pilotos[piloto] for piloto in pilotos)
        pontuacoes_etapa_equipes[equipe] += pontuacao_equipe

    
    for piloto, pontuacao in pontuacoes_etapa_pilotos.items():
        tabela_hash_pontuacoes_pilotos[piloto] += pontuacao

    for equipe, pontuacao in pontuacoes_etapa_equipes.items():
        tabela_hash_pontuacoes_equipes[equipe] += pontuacao


maior_pontuador = max(tabela_hash_pontuacoes_pilotos, key=tabela_hash_pontuacoes_pilotos.get)


print("\nResultados Finais:")
print(f"Maior Pontuador:")
equipe_maior_pontuador = [equipe for equipe, pilotos in equipes.items() if maior_pontuador in pilotos][0]
print(f"{maior_pontuador} ({equipe_maior_pontuador}) - Pontuação Total: {tabela_hash_pontuacoes_pilotos[maior_pontuador]} pontos")

vencedor_equipe = max(tabela_hash_pontuacoes_equipes, key=tabela_hash_pontuacoes_equipes.get)

end_time = time.time()

print(f"\nEquipe Campeã: {vencedor_equipe} - Pontuação Total: {tabela_hash_pontuacoes_equipes[vencedor_equipe]} pontos")
print(f"Tempo de execução: {end_time - start_time} segundos")
