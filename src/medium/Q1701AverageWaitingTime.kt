package medium

class Q1701AverageWaitingTime {
    fun averageWaitingTime(customers: Array<IntArray>): Double {
        var numCustomer = 0
        var totalWaitTime = 0.0

        var toBeCompletedAt = 0
        for(customer in customers) {
            val arrivalTime = customer[0]
            val leadTime = customer[1]
            
            val toWait = toBeCompletedAt - arrivalTime
            if(toWait <= 0) {
                totalWaitTime += leadTime
                toBeCompletedAt = arrivalTime + leadTime
            } else {
                totalWaitTime += toWait + leadTime
                toBeCompletedAt += leadTime
            }

            numCustomer++
        }
        
        return totalWaitTime/ numCustomer
    }
}