def time_to_second(time : str):
    m, s = map(int, time.split(':'))
    return m * 60 + s
    

def solution(video_len, pos, op_start, op_end, commands):
    # prev -> 10초 전으로 되돌림
    # next -> 10초 앞으로 이동함
    # 오프닝 건너뛰기 -> 오프닝 구간일때 오프닝이 끝나는 위치로 이동
    
    video_len_sec = time_to_second(video_len)
    pos_sec = time_to_second(pos)
    op_start_sec = time_to_second(op_start)
    op_end_sec = time_to_second(op_end)
        
    if op_start_sec <= pos_sec <= op_end_sec:
        pos_sec = op_end_sec    
        
    for command in commands:
        if command == "next":
            pos_sec += 10
        else:
            pos_sec -= 10
        
        # 비디오 끝 시작 구분
        if pos_sec < 0:
            pos_sec = 0
        
        if pos_sec >= video_len_sec:
            pos_sec = video_len_sec
        
        if op_start_sec <= pos_sec <= op_end_sec:
            pos_sec = op_end_sec
            

    # 이제 문제 조건에 맞게 변환한다
    minute = int(pos_sec / 60)
    second = pos_sec % 60
    
    answer_min = str(minute) if minute >= 10 else '0' + str(minute)
    answer_sec = str(second) if second >= 10 else '0' + str(second)
    
    return answer_min + ":" + answer_sec