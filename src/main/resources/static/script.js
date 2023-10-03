document.addEventListener("DOMContentLoaded", function() {
	const bmiForm = document.getElementById("bmiForm");

	bmiForm.addEventListener("submit", function(event) {
		if (!formValidation()) {
			event.preventDefault();
		}
	});

	function formValidation() {
		let isValid = true;
		const ageInput = document.getElementById("age");
		const heightInput = document.getElementById("height");
		const weightInput = document.getElementById("weight");

		const age = parseFloat(ageInput.value);
		const height = parseFloat(heightInput.value);
		const weight = parseFloat(weightInput.value);

		// Remove existing error messages
		removeErrorMessage(ageInput);
		removeErrorMessage(heightInput);
		removeErrorMessage(weightInput);

		if (isNaN(age) || age <= 0) {
			isValid = false;
			displayErrorMessage(ageInput, "Please enter a valid age.");
		}

		if (isNaN(weight) || weight <= 0) {
			isValid = false;
			displayErrorMessage(weightInput, "Please enter a valid weight.");
		}

		if (isNaN(height) || height <= 0) {
			isValid = false;
			displayErrorMessage(heightInput, "Please enter a valid height.");
		}

		return isValid;
	}

	function displayErrorMessage(inputElement, errorMessage) {
		const errorDiv = document.createElement("div");
		errorDiv.className = "text-danger";
		errorDiv.textContent = errorMessage;

		inputElement.parentNode.appendChild(errorDiv);
	}

	function removeErrorMessage(inputElement) {
		const errorDiv = inputElement.parentNode.querySelector(".text-danger");
		if (errorDiv) {
			inputElement.parentNode.removeChild(errorDiv);
		}
	}
});