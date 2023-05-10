# O(2n) time - 2 loops, O(n) space
def tournamentWinner(competitions, results):
    # results[i] == 1 means competitions[i][0] won
    # results[i] == 0 means competitions[i][1] won
    # dict of all teams with points assigned
    scorecard = dict()
    for idx,i in enumerate(results):
        if i == 1:
            if scorecard.get(competitions[idx][0]):
                scorecard[competitions[idx][0]] = scorecard.get(competitions[idx][0])+1
            else: 
                scorecard[competitions[idx][0]] = 1
        else:
            if scorecard.get(competitions[idx][1]):
                scorecard[competitions[idx][1]] = scorecard.get(competitions[idx][1])+1
            else: 
                scorecard[competitions[idx][1]] = 1
    highest = 0
    name = ''
    for key,value in scorecard.items():
        if value > highest:
            highest = value
            name = key
    return name
