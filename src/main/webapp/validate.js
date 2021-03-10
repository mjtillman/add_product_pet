function validateForm() {
  const petName = document.forms["addPetForm"]["petName"].value;
  const petType = document.forms["addPetForm"]["petType"].value;
  const petColor = document.forms["addPetForm"]["petColor"].value;
  const petFee = document.forms["addPetForm"]["petFee"].value;
  const formMsg = document.getElementById("formMsg");

  if (petName.length === 0) {
    formMsg.innerHTML = "Pet name must be filled out";
    return false;
  } else if (petType.length === 0) {
    formMsg.innerHTML = "Animal type must be filled out";
    return false;
  } else if (petColor.length === 0) {
    formMsg.innerHTML = "Color must be selected";
    return false;
  } else if (petFee.length === 0) {
    formMsg.innerHTML = "Adoption fee must be filled out";
    return false;
  } else if (isNaN(petFee)) {
    formMsg.innerHTML = "Invalid input in adoption fee, please enter a number";
    return false;
  } else {
    return true;
  }
}