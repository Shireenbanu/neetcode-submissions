class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            Integer node1 = prerequisites[i][1];
            Integer node2 = prerequisites[i][0];
            if (!map.containsKey(node1)) {
                List<Integer> list = new ArrayList<>();
                list.add(node2);
                map.put(node1, list);
            } else {
                List<Integer> list = map.get(node1);
                list.add(node2);
            }
        }

        // System.out.println("map: "+ map);
        int visited[] = new int[numCourses];
        int visiting[] = new int[numCourses];
        boolean res = true;
        for(int i=0; i<numCourses; i++){
        res = traverseDFS(map, i, visited, visiting);
        if(res == false)
        break;
        }
        // System.out.println("ans "+ res);
        return res;
    }

    public boolean traverseDFS(
        HashMap<Integer, List<Integer>> map, int item, int[] visited, int[] visiting) {
        List<Integer> list = map.get(item);
        boolean flag = true;
        if (visiting[item] != 0) {
            flag = false;
            // System.out.println("Cycle exists: " + flag);
            return flag;
        } else {
            if (list != null) {
                // System.out.println("item: " + list);
                int n = list.size() - 1;
                visiting[item] = 1;
                while (n >= 0) {
                    flag = traverseDFS(map, list.get(n), visited, visiting);
                    if(flag == false)
                    return flag;
                    n--;
                }
            }
        }
        visiting[item] = 0;
        visited[item] = 1;
        return flag;
    }
}
