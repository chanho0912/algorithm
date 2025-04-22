package com.linecorp.lcp.config.solve.baekjoon

/**
 * 방향 이동 좌표
 */
val direction = arrayOf(
    -1 to 0, // 북
    0 to 1, // 동
    1 to 0, // 남
    0 to -1, // 서
)

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    var (left, right, dir) = readln().split(" ").map { it.toInt() }

    val arr = Array(n) { IntArray(m) }

    for (i in 0 until n)
        arr[i] = readln().split(" ").map { it.toInt() }.toIntArray()

    /**
     * 결과 값
     */
    var count = 0

    // 74 83 92
    while (left < n && right < m) {
        // 현재 칸 청소
        if (arr[left][right] == 0) {
            arr[left][right] = 2
            count += 1
        }

        // 주변 4칸 확인
        var hasDirty = false
        for (d in direction)
            if (left + d.first < n && right + d.second < m)
                if (arr[left + d.first][right + d.second] == 0) hasDirty = true


        if (!hasDirty) {
            // 180도 회전
            var nextDir = dir + 2
            if (nextDir > 3) nextDir = nextDir % 4

            // 범위 밖이면 break
            if (left + direction[nextDir].first >= n || right + direction[nextDir].second >= m) break

            // 벽이라 후진 할 수 없으면 break
            if (arr[left + direction[nextDir].first][right + direction[nextDir].second] == 1) break

            // 후진
            left = left + direction[nextDir].first
            right = right + direction[nextDir].second
            continue
        }

        // 90도 회전
        dir = dir + 3
        if (dir > 3) dir = dir % 4

        // 범위 밖이면 break
        if (left + direction[dir].first >= n || right + direction[dir].second >= m) break

        // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
        if (arr[left + direction[dir].first][right + direction[dir].second] == 0) {
            left = left + direction[dir].first
            right = right + direction[dir].second
        }
    }

    println("$count")
}
