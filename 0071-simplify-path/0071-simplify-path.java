class Solution {
    public String simplifyPath(String path) {
        List<String> stack = new ArrayList<>();
        String[] components = path.split("/");
        
        for (String comp : components) {
            if (comp.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.remove(stack.size() - 1);
                }
            } else if (!comp.isEmpty() && !comp.equals(".")) {
                stack.add(comp);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        
        return result.length() == 0 ? "/" : result.toString();
    }
}