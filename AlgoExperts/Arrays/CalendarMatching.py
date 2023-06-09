# took too long, didn't finish.
def calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration):
    # cal1 = [[startTime,endTime],[s,e]].
    # takes both calendars, return a list of all timeblocks in form of [startTime,endTime]
    # that are available to schedule meeting. use military time
    # given calendar times wil be sorted by start time in ascending
    # combine daily bounds, compare cal1 and cal2 and get all busy times
    # take cal3 and find all time when free using the daily bounds combined
    # take meetingDuration and find how much it fits for all free times
    
    # totalBound will be higher number between dailybounds[0] and lower number of dbounds[1]
    # if numbers == each other, then we split() and compare the [1] , we take the higher
    # for dbounds[1] we get the lower, if same then split and compare the [1], take the lower.
    totalBound = []
    c = dailyBounds1[0].split(":")
    d = dailyBounds2[0].split(":")
    if c[0] == d[0]:
        totalBound.append(c+":"+max(dc[1],d[1]))
    else if c[0] > d[0]:
        totalBound.append(dailyBounds1[0])
    else:
        totalBound.append(dailyBounds2[0])
    a = dailyBounds1[1].split(":")
    b = dailyBounds2[1].split(":")
    if a[0] == b[0]:
        totalBound.append(a+":"+min(a[1],b[1]))
    else if a[0] > b[0]:
        totalBound.append(dailyBounds2[1])
    else:
        totalBound.append(dailyBounds1[1])
    # for cal3, we combine cal1 and cal2 together, will have to use sorted() afterwards
    cal3 = sorted(cal1 + cal2)
    # we can loop through, compare curr with next, if curr[1] < next[0], we can add curr to cal3
    # else, then do a while loop linked to a new variable (j), j will equal same index of next at start
    # we'll move j+=1, check if next index[1] < curr, if true then continue
    # else: we check if it's greater than index[0]: if true, we append the combined of curr[0],index[1]
    # else we append only curr, also i(from original while loop) becomes same value of j
    
    
    # once we have everything that's busy, we can compare with totalbound and check for free times
    # have a variable equal [10,00], add meeting duration, add count, if == 60, then add 1 to 10
    # if daily bound == block time index, compare second part of time, if true, then original number jumps
    # end range
    
    pass
