class FileSystem {
    Map<String,Integer> map;

    public FileSystem() {
        map = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        if(path.equals("") || path.equals("/")) return false;
        if(map.containsKey(path)) return false; // path already exists

        // find parent path
        int idx = path.lastIndexOf("/");
        String parent = path.substring(0, idx);

        if(parent.length() > 0 && !map.containsKey(parent)) {
            return false; // parent does not exist
        }

        map.put(path, value);
        return true;
    }

    public int get(String path) {
        return map.getOrDefault(path, -1);
    }
}
