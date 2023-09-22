const fixedExtensions = ["bat", "cmd", "com", "cpl", "exe", "src", "js"];
const fixedExtensionsDiv = document.getElementById("fixed-extensions-items");
const customExtensions = [];

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

const deleteSVG = `<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 384 512"><path d="M376.6 84.5c11.3-13.6 9.5-33.8-4.1-45.1s-33.8-9.5-45.1 4.1L192 206 56.6 43.5C45.3 29.9 25.1 28.1 11.5 39.4S-3.9 70.9 7.4 84.5L150.3 256 7.4 427.5c-11.3 13.6-9.5 33.8 4.1 45.1s33.8 9.5 45.1-4.1L192 306 327.4 468.5c11.3 13.6 31.5 15.4 45.1 4.1s15.4-31.5 4.1-45.1L233.7 256 376.6 84.5z"/></svg>`;

function displayCustomExtensions() {
  const selectedExtensionsSpan = document.getElementById(
    "added-items-extensions"
  );
  selectedExtensionsSpan.innerHTML = "";

  customExtensions.forEach((ext) => {
    const newDiv = document.createElement("span");
    newDiv.className = "extension-item";

    const extName = document.createElement("span");
    extName.textContent = ext;
    newDiv.appendChild(extName);

    const deleteBtn = document.createElement("button");
    deleteBtn.className = "added-button";
    deleteBtn.innerHTML = deleteSVG;
    deleteBtn.onclick = function () {
      const index = customExtensions.indexOf(ext);
      if (index > -1) {
        customExtensions.splice(index, 1);
      }
      displayCustomExtensions();
    };
    newDiv.appendChild(deleteBtn);

    selectedExtensionsSpan.appendChild(newDiv);
  });
  updateSelectedCount();
}

function addCustomExtension() {
  if (customExtensions.length >= MAX_SELECTED) {
    alert("최대 200개의 확장자만 추가할 수 있습니다.");
    document.getElementById("custom-extension-input").value = "";
    return;
  }

  const inputValue = document
    .getElementById("custom-extension-input")
    .value.trim();

  const regex = /^.{1,19}$/;
  if (!regex.test(inputValue)) {
    alert("확장자 이름은 20글자 미만이어야 합니다.");
    document.getElementById("custom-extension-input").value = "";
    return;
  }

  if (inputValue && !customExtensions.includes(inputValue)) {
    customExtensions.push(inputValue);
    displayCustomExtensions();
    document.getElementById("custom-extension-input").value = "";
  }
}

const MAX_SELECTED = 200;
const selectedCountSpan = document.getElementById("added-items-count");

function updateSelectedCount() {
  selectedCountSpan.textContent = `${customExtensions.length}/${MAX_SELECTED}`;
}

displayFixedExtensions();
displayCustomExtensions();