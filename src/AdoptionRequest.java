public class AdoptionRequest {
    private int id;
    private int userId;
    private int petId;
    private String status;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getPetId() { return petId; }
    public void setPetId(int petId) { this.petId = petId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
