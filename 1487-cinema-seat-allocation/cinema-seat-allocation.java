class Solution {
    private int getSeats(List<Integer> list) {
        Collections.sort(list);
        if(list.size() == 3) {
            return 2;
        } else if(list.size() == 2) {
            return (list.get(0) == 0 && list.get(1) == 2) ? 2 : 1;
        }
        return list.size();
    }
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int maxAllocation = n * 2;
        Map<Integer, List<Integer>> map = new HashMap();
        for(int[] seats: reservedSeats) {
            int row = seats[0];
            int seat = seats[1];
            if(seat > 1 && seat < 10) {
                if(map.containsKey(row)) {
                    if(seat >= 2 && seat <= 5 && !map.get(row).contains(0)) {
                        map.get(row).add(0);
                    }
                    if(seat >= 4 && seat <= 7 && !map.get(row).contains(1)) {
                        map.get(row).add(1);
                    }
                    if(seat >= 6 && seat <= 9 && !map.get(row).contains(2)) {
                        map.get(row).add(2);
                    }
                } else {
                    List<Integer> list = new ArrayList();
                    if(seat >= 2 && seat <= 5) {
                        list.add(0);
                    }
                    if(seat >= 4 && seat <= 7) {
                        list.add(1);
                    }
                    if(seat >= 6 && seat <= 9) {
                        list.add(2);
                    }
                    map.put(row, list);
                }
            }
        }
        System.out.println(map);
        for(Map.Entry<Integer, List<Integer>> entrySet: map.entrySet()) {
            int size =  entrySet.getValue().size();
            maxAllocation -= size > 1 ? size - 1 : size;
        }
        return maxAllocation;
    }
}