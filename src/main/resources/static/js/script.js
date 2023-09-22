const fixedExtensions = ["bat", "cmd", "com", "cpl", "exe", "src", "js"];
const fixedExtensionsDiv = document.getElementById("fixed-extensions-items");

function displayFixedExtensions() {
  fixedExtensionsDiv.innerHTML = "";
  fixedExtensions.forEach((ext) => {
    const label = document.createElement("label");
    const checkbox = document.createElement("input");
    checkbox.type = "checkbox";
    checkbox.value = ext;
    checkbox.id = "fixed-" + ext;
    label.appendChild(checkbox);
    label.appendChild(document.createTextNode(" " + ext));
    fixedExtensionsDiv.appendChild(label);
  });
}

displayFixedExtensions();