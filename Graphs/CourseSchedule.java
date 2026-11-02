class CourseSchedule {
    boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> dependenciesMap = new HashMap<>();

        for (int[] pair : prerequisites) {
            int a = pair[0];
            int b = pair[1];

            if (!dependenciesMap.containsKey(a))
                dependenciesMap.put(a, new ArrayList<>());

            dependenciesMap.get(a).add(b);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] inPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++)
            if (hasDependencyCycle(i, dependenciesMap, visited, inPath))
                return false;

        return true;
    }

    boolean hasDependencyCycle(
            int course,
            HashMap<Integer, ArrayList<Integer>> dependenciesMap,
            boolean[] visited,
            boolean[] inPath) {

        if (inPath[course])
            return true;

        if (visited[course])
            return false;

        inPath[course] = true;

        if (dependenciesMap.containsKey(course))
            for (int dependency : dependenciesMap.get(course))
                if (hasDependencyCycle(dependency, dependenciesMap, visited, inPath))
                    return true;

        inPath[course] = false;
        visited[course] = true;

        return false;
    }
}