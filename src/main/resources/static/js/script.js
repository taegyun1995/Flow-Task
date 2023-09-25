let fixedExtensions = [];
const fixedExtensionsDiv = document.getElementById("fixed-extensions-items");
let customExtensions = [];
let deleteSVG;

function displayFixedExtensions(extensions) {
    fixedExtensionsDiv.innerHTML = "";
    extensions.forEach((extObj) => {
        const label = document.createElement("label");
        const checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        checkbox.value = extObj.name;

        if (extObj.status === "CHECK") {
            checkbox.checked = true;
        }
        checkbox.addEventListener("change", function() {
            updateExtensionStatus(extObj.id, this.checked);
        });

        label.appendChild(checkbox);
        label.appendChild(document.createTextNode(" " + extObj.name));
        fixedExtensionsDiv.appendChild(label);
    });
}

function loadSVGIcon(callback) {
    $.get("/static/svg/delete-icon.svg", function(data) {
        const svgString = new XMLSerializer().serializeToString(data.documentElement);
        callback(svgString);
    });
}

loadSVGIcon(function(svgString) {
    deleteSVG = svgString;
});

function displayCustomExtensions() {
    const selectedExtensionsSpan = document.getElementById("added-items-extensions");
    selectedExtensionsSpan.innerHTML = "";
    customExtensions.forEach((ext) => {
        const newDiv = document.createElement("span");
        newDiv.className = "extension-item";

        const extName = document.createElement("span");
        extName.textContent = ext.name || ext;
        newDiv.appendChild(extName);

        const deleteBtn = document.createElement("button");
        deleteBtn.className = "added-button";
        deleteBtn.innerHTML = deleteSVG;
        deleteBtn.onclick = function () {
            deleteCustomExtension(ext.id);
        };

        newDiv.appendChild(deleteBtn);
        selectedExtensionsSpan.appendChild(newDiv);
    });
    updateSelectedCount();
}

function handleServerError(response) {
    alert(response.message);
}

function addCustomExtension() {
    if (customExtensions.length >= MAX_SELECTED) {
        alert("최대 200개의 확장자만 추가할 수 있습니다.");
        document.getElementById("custom-extension-input").value = "";
        return;
    }

    const inputValue = document.getElementById("custom-extension-input").value.trim();

    if (fixedExtensions.some(extObj => extObj.name === inputValue)) {
        alert("이미 고정 확장자로 등록된 항목입니다.");
        document.getElementById("custom-extension-input").value = "";
        return;
    }

    const regex = /^.{1,19}$/;
    if (!regex.test(inputValue)) {
        alert("확장자 이름은 20글자 미만이어야 합니다.");
        document.getElementById("custom-extension-input").value = "";
        return;
    }

    if (inputValue && !customExtensions.includes(inputValue)) {
        $.ajax({
            url: "/custom/extension",
            type: "POST",
            data: JSON.stringify({ extensionName: inputValue }),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(response) {
                customExtensions.push(response.customExtensionName);
                fetchCustomExtensions();
                displayCustomExtensions();
                document.getElementById("custom-extension-input").value = "";
            },
            error: function(jqXHR) {
                const response = jqXHR.responseJSON;
                handleServerError(response);
                document.getElementById("custom-extension-input").value = "";
            }
        });
    }

}

const MAX_SELECTED = 200;
const selectedCountSpan = document.getElementById("added-items-count");

function updateSelectedCount() {
    selectedCountSpan.textContent = `${customExtensions.length}/${MAX_SELECTED}`;
}

function fetchFixedExtensions() {
    $.ajax({
        url: "/fixed/extensions",
        type: "GET",

        success: function(response) {
            fixedExtensions = response.responseList;
            displayFixedExtensions(fixedExtensions);
        },
        error: function(jqXHR) {
            const response = jqXHR.responseJSON;
            handleServerError(response);
        }
    });
}

function updateExtensionStatus(id, isChecked) {
    let endpoint;

    if (isChecked) {
        endpoint = `/fixed/extension/${id}/check`;
    } else {
        endpoint = `/fixed/extension/${id}/uncheck`;
    }

    $.ajax({
        url: endpoint,
        type: "PUT",
        success: function(response) {
        },
        error: function(jqXHR) {
            const response = jqXHR.responseJSON;
            handleServerError(response);
        }
    });
}

function fetchCustomExtensions() {
    $.ajax({
        url: "/custom/extensions",
        type: "GET",
        success: function(response) {
            customExtensions = response.responseList;
            displayCustomExtensions();
        },
        error: function(jqXHR) {
            const response = jqXHR.responseJSON;
            handleServerError(response);
        }
    });
}

function deleteCustomExtension(extensionId) {
    $.ajax({
        url: `/custom/extension/${extensionId}/delete`,
        type: "DELETE",
        success: function(response) {
            customExtensions = customExtensions.filter(ext => ext.id !== extensionId);
            displayCustomExtensions();
        },
        error: function(jqXHR) {
            const response = jqXHR.responseJSON;
            handleServerError(response);
        }
    });
}

function initialize() {
    fetchFixedExtensions();
    displayCustomExtensions();
    fetchCustomExtensions();
}

$(document).ready(initialize);